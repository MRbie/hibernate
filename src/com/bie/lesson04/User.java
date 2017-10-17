package com.bie.lesson04;

import java.util.Set;

/** 
* @author  Author:别先生 
* @date Date:2017年10月17日 下午8:36:36 
*
*
*/
public class User {

	private int userId;//用户得编号
	private String userName;//用户得姓名
	//一个用户对应多个地址信息
	private Set<String> address;//用户得地址信息
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Set<String> getAddress() {
		return address;
	}
	public void setAddress(Set<String> address) {
		this.address = address;
	}
	
	
}
