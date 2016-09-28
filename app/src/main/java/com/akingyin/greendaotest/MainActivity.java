package com.akingyin.greendaotest;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  public static Uri contentUri = Uri.parse("content://com.zlcdgroup.user.provider/tb_user");
  ContentResolver contentResolver;
  DemoAdapter  adapter;
  RecyclerView  recyclerview;
  FloatingActionButton  fab_autor;
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
    fab_autor = (FloatingActionButton)findViewById(R.id.fab_autor);
    if(null == contentResolver ){
      contentResolver = getContentResolver();
    }

    fab_autor.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        List<User> data = new ArrayList<>();
        queryData(data);
        adapter.getData().clear();
        adapter.addData(data);
        adapter.notifyDataSetChanged();
      }
    });
    List<User> data = new ArrayList<>();
    queryData(data);

    adapter = new DemoAdapter(R.layout.item_view,data);
    recyclerview.setItemAnimator(new DefaultItemAnimator());
    recyclerview.setLayoutManager(new LinearLayoutManager(this));
    recyclerview.setAdapter(adapter);


  }

  public   void   queryData(List<User> data){
    Cursor cursor = contentResolver.query(contentUri, null, null, null, null);
    System.out.println("null == cursor"+(null == cursor));
    if(null != cursor){

      if(cursor.moveToFirst()){
        String[]  columns = cursor.getColumnNames();

        while (cursor.moveToNext()){
          User  userEntity = new User();

          userEntity.arg = cursor.getString(cursor.getColumnIndex("ARG"));

          userEntity.account = cursor.getString(cursor.getColumnIndex("ACCOUNT"));

          userEntity.uuid = cursor.getString(cursor.getColumnIndex("UUID"));

          userEntity.setId(cursor.getLong(cursor.getColumnIndex(BaseColumns._ID)));
          data.add(userEntity);
        }
        cursor.close();
      }
    }
  }
}
