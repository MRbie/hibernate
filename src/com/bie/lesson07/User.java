package com.bie.lesson07;
/** 
* @author  Author:������ 
* @date Date:2017��10��28�� ����7:10:00 
*
* ����:�û������֤��Ϣ
* 	һ���û���¼��Ӧһ�����֤��Ϣ��һ��һ�Ĺ�ϵ��
*/
public class User {

	private int userId;//�û����
	private String userName;//�û�����
	//�û������֤��Ϣ��һ��һ��ϵ��
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
