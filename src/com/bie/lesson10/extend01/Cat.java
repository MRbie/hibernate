package com.bie.lesson10.extend01;
/** 
* @author  Author:别先生 
* @date Date:2017年10月28日 下午9:27:04 
*
* 简单继承映射。
*/
public class Cat extends Animal{

	private String catchMouse;//猫的特性，抓老鼠

	public String getCatchMouse() {
		return catchMouse;
	}
	public void setCatchMouse(String catchMouse) {
		this.catchMouse = catchMouse;
	}
	@Override
	public String toString() {
		return "Cat [catchMouse=" + catchMouse + "]";
	}
	
	
}
