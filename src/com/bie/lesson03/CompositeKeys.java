package com.bie.lesson03;

import java.io.Serializable;

/** 
* @author  Author:������ 
* @date Date:2017��10��15�� ����8:46:33 
*
* ����������ʵ����
*/
public class CompositeKeys implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;//����
	private String Number;//���֤
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	
}
