package com.akingyin.greendaotest;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  public static Uri contentUri = Uri.parse("content://com.zlcdgroup.user.provider/tb_user");
  ContentResolver contentResolver;
  DemoAdapter  adapter;
  RecyclerView  recyclerview;
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerview = (RecyclerView)findViewById(R.id.recyclerview);

    if(null == contentResolver ){
      contentResolver = getContentResolver();
    }

    Cursor cursor = contentResolver.query(contentUri, null, null, null, null);
    List<User> data = new ArrayList<>();
    if(null != cursor){
      System.out.println("count="+cursor.getCount());
      while (cursor.moveToNext()){
        User  userEntity = new User();
        userEntity.arg = cursor.getString(cursor.getColumnIndex("AGE"));
        userEntity.account = cursor.getString(cursor.getColumnIndex("ACCOUNT"));

        userEntity.setId(cursor.getLong(cursor.getColumnIndex(BaseColumns._ID)));
        data.add(userEntity);
      }
      cursor.close();
    }
    adapter = new DemoAdapter(R.layout.item_view,data);
    recyclerview.setItemAnimator(new DefaultItemAnimator());
    recyclerview.setLayoutManager(new LinearLayoutManager(this));
    recyclerview.setAdapter(adapter);
    System.out.println("data.size="+data.size());

  }
}
