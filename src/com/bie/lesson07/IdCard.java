package com.bie.lesson07;
/** 
* @author  Author:������ 
* @date Date:2017��10��28�� ����7:13:38 
*
*
*/
public class IdCard {

	//private String cardId;
	//����Ψһ��ʶ��(Object Identified,OID)
	private String cardNumber;//���֤����������
	private String place;//��ַ
	//���֤���û�һ��һ�Ķ�Ӧ��ϵ
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
