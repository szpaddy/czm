package com.czmen.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息。
 * 
 * @author YANGYONG
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = 55620551623017987L;
	
	/**
	 * 用户ID。
	 */
	private int id;
	/**
	 * 用户手机号，作为唯一标识。
	 */
	private String mobile;
	
	/**
	 * 用户昵称。
	 */
	private String nickname;
	
	/**
	 * 用户密码。
	 */
	private String password;
	
	/**
	 * 注册时间。
	 */
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	} 
}
