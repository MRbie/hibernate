package com.bie.lesson09;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:别先生 
* @date Date:2017年10月28日 下午9:18:35 
*
*
*/
public class ComponentTest {

	@Test
	public void test(){
		Session session = HibernateUtils.getSesion();
		Transaction tx = session.beginTransaction();
		
		//轮子
		Wheel wheel = new Wheel();
		wheel.setCount(400);
		wheel.setSize(200);
		
		//汽车
		Car car = new Car();
		car.setCarName("迈巴赫");
		//设置关系
		car.setWheel(wheel);
		
		//保存操作
		session.save(car);
		tx.commit();
		session.close();
	}
	
}
