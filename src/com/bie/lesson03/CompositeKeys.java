package com.bie.lesson03;

import java.io.Serializable;

/** 
* @author  Author:别先生 
* @date Date:2017年10月15日 下午8:46:33 
*
* 复合主键的实体类
*/
public class CompositeKeys implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;//姓名
	private String Number;//身份证
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
