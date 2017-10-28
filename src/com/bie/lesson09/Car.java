package com.bie.lesson09;
/** 
* @author  Author:别先生 
* @date Date:2017年10月28日 下午8:48:00 
* 1:组件映射与继承映射
* 	类的关系：
* 		(1)组合关系，一个类中包含了另一个类。这2个类就是组合关系。
* 			需求:汽车和轮船
* 		(2)继承关系:一个类继承了另一个类。这2个类中就是继承关系。
*			需求：动物：猫，狗，猴子等等。
* 2:组件映射
* 	类组合关系的映射，也叫做组件映射。
* 	注意：组件类和被包含的组件类，共同映射到一张表上面。
* 
* 3:继承映射
*/
public class Car {

	private int carId;//汽车编号
	private String carName;//汽车名称
	//车轮
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
