package com.bie.lesson09;
/** 
* @author  Author:������ 
* @date Date:2017��10��28�� ����8:48:00 
* 1:���ӳ����̳�ӳ��
* 	��Ĺ�ϵ��
* 		(1)��Ϲ�ϵ��һ�����а�������һ���ࡣ��2���������Ϲ�ϵ��
* 			����:�������ִ�
* 		(2)�̳й�ϵ:һ����̳�����һ���ࡣ��2�����о��Ǽ̳й�ϵ��
*			���󣺶��è���������ӵȵȡ�
* 2:���ӳ��
* 	����Ϲ�ϵ��ӳ�䣬Ҳ�������ӳ�䡣
* 	ע�⣺�����ͱ�����������࣬��ͬӳ�䵽һ�ű����档
* 
* 3:�̳�ӳ��
*/
public class Car {

	private int carId;//�������
	private String carName;//��������
	//����
	private Wheel wheel;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public Wheel getWheel() {
		return wheel;
	}
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}
	
}
