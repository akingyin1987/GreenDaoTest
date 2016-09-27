package com.akingyin.greendaotest;



/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/9/26 10:43
 * @ Version V1.0
 */


public class User    {


  public  String    account;

  public  String    arg;


  private Long id;



  public   int   webid;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public   int   userId;


  public  String   uuid;


  public   String   temp;


  public User(String account, String arg, Long id, int webid, int userId,
      String uuid) {
    this.account = account;
    this.arg = arg;
    this.id = id;
    this.webid = webid;
    this.userId = userId;
    this.uuid = uuid;
  }


  public User() {
  }

  public String getAccount() {
    return this.account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getArg() {
    return this.arg;
  }

  public void setArg(String arg) {
    this.arg = arg;
  }

  public int getUserId() {
    return this.userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUuid() {
    return this.uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public int getWebid() {
    return this.webid;
  }

  public void setWebid(int webid) {
    this.webid = webid;
  }
}
