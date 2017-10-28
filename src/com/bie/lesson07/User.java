package com.bie.lesson07;
/** 
* @author  Author:别先生 
* @date Date:2017年10月28日 下午7:10:00 
*
* 需求:用户和身份证信息
* 	一条用户记录对应一条身份证信息，一对一的关系。
*/
public class User {

	private int userId;//用户编号
	private String userName;//用户姓名
	//用户与身份证信息，一对一关系。
	private IdCard idCard;//
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
	public IdCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
	
	
}
