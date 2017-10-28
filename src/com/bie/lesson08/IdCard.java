package com.bie.lesson08;
/** 
* @author  Author:别先生 
* @date Date:2017年10月28日 下午7:13:38 
*
*
*/
public class IdCard {

	private int userId;
	private String cardNumber;//身份证号码
	private String place;//地址
	//身份证与用户一对一的对应关系
	private User user;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
