package com.bie.lesson10.extend04;
/** 
* @author  Author:别先生 
* @date Date:2017年10月28日 下午9:27:04 
*
* 1:简单继承映射。
* 	(1):总结，有多少子类，就写多少个映射配置文件。
* 
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
