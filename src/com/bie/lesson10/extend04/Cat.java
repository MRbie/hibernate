package com.bie.lesson10.extend04;
/** 
* @author  Author:������ 
* @date Date:2017��10��28�� ����9:27:04 
*
* 1:�򵥼̳�ӳ�䡣
* 	(1):�ܽᣬ�ж������࣬��д���ٸ�ӳ�������ļ���
* 
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
