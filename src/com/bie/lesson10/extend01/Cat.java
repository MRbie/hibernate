package com.bie.lesson10.extend01;
/** 
* @author  Author:������ 
* @date Date:2017��10��28�� ����9:27:04 
*
* �򵥼̳�ӳ�䡣
*/
public class Cat extends Animal{

	private String catchMouse;//è�����ԣ�ץ����

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
