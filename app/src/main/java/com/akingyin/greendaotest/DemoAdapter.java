package com.akingyin.greendaotest;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import java.util.List;
import org.json.JSONObject;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/9/27 18:00
 * @ Version V1.0
 */

public class DemoAdapter  extends BaseQuickAdapter<User> {


  public DemoAdapter(int layoutResId, List<User> data) {
    super(layoutResId, data);
  }

  @Override protected void convert(BaseViewHolder baseViewHolder, User user) {
    baseViewHolder.setText(R.id.tv_number,"1");
    baseViewHolder.setText(R.id.tv_data, new Gson().toJson(user));

  }
}
