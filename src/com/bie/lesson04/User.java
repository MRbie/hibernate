package com.bie.lesson04;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
	
	//һ���û���Ӧ�����ַ��Ϣ
	private List<String> addressList = new LinkedList<String>();
	
	//һ���û���Ӧ�����ַ��Ϣ
	//��ַ�ļ�ƺ͵�ַ��ȫ��
	private Map<String,String> addressMap = new HashMap<String,String>();
	
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
	public List<String> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	public Map<String, String> getAddressMap() {
		return addressMap;
	}
	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}
	
	
}
