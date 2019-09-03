package com.keven.springDemo.entity;
import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class User implements Serializable {

	private String userid;

	private String usernm;

	private String userpw;

	private String uemail;

	private String uphone;
	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public User(String userid, String usernm, String userpw, String uemail, String uphone) {
		super();
		this.userid = userid;
		this.usernm = usernm;
		this.userpw = userpw;
		this.uemail = uemail;
		this.uphone = uphone;
	}

	
	public User() {
		super();

	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", usernm=" + usernm + ", userpw=" + userpw + ", uemail=" + uemail
				+ ", uphone=" + uphone + "]";
	}
	
	public static void main(String[] args) {
		User user =new User();
        user.setUserid("user1001");
        user.setUsernm("admin");
        user.setUserpw("redis");
        user.setUemail("9873281@qq.com");
        user.setUphone("12345678");
        JSONObject toJson = (JSONObject) JSONObject.toJSON(user);
        String jsonStr =toJson.toJSONString();
        System.out.println(jsonStr);
       
        user =  JSONObject.parseObject(jsonStr, User.class);
        System.out.println(user.getUserid());
        
	}
	
	
	

}
