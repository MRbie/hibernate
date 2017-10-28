package com.bie.lesson07;
/** 
* @author  Author:别先生 
* @date Date:2017年10月28日 下午7:13:38 
*
*
*/
public class IdCard {

	//private String cardId;
	//对象唯一标识，(Object Identified,OID)
	private String cardNumber;//身份证号码做主键
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
	
	
}
