package com.bie.lesson04;

import java.util.Set;

/** 
* @author  Author:������ 
* @date Date:2017��10��17�� ����8:36:36 
*
*
*/
public class User {

	private int userId;//�û��ñ��
	private String userName;//�û�������
	//һ���û���Ӧ�����ַ��Ϣ
	private Set<String> address;//�û��õ�ַ��Ϣ
	
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
