package com.keven.shiro.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_info.uid
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private Integer uid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_info.name
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_info.password
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_info.create_time
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private Date createTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_info.last_login_time
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private Date lastLoginTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_info.salt
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private String salt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_info.state
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private Byte state;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user_info.username
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user_info
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_info.uid
	 * @return  the value of user_info.uid
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_info.uid
	 * @param uid  the value for user_info.uid
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_info.name
	 * @return  the value of user_info.name
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_info.name
	 * @param name  the value for user_info.name
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_info.password
	 * @return  the value of user_info.password
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_info.password
	 * @param password  the value for user_info.password
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_info.create_time
	 * @return  the value of user_info.create_time
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_info.create_time
	 * @param createTime  the value for user_info.create_time
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_info.last_login_time
	 * @return  the value of user_info.last_login_time
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_info.last_login_time
	 * @param lastLoginTime  the value for user_info.last_login_time
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_info.salt
	 * @return  the value of user_info.salt
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_info.salt
	 * @param salt  the value for user_info.salt
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setSalt(String salt) {
		this.salt = salt == null ? null : salt.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_info.state
	 * @return  the value of user_info.state
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public Byte getState() {
		return state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_info.state
	 * @param state  the value for user_info.state
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setState(Byte state) {
		this.state = state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user_info.username
	 * @return  the value of user_info.username
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user_info.username
	 * @param username  the value for user_info.username
	 * @mbg.generated  Mon Oct 14 11:48:22 CST 2019
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}
}