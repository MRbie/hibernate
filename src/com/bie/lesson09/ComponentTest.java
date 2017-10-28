package com.bie.lesson09;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:������ 
* @date Date:2017��10��28�� ����9:18:35 
*
*
*/
public class ComponentTest {

	@Test
	public void test(){
		Session session = HibernateUtils.getSesion();
		Transaction tx = session.beginTransaction();
		
		//����
		Wheel wheel = new Wheel();
		wheel.setCount(400);
		wheel.setSize(200);
		
		//����
		Car car = new Car();
		car.setCarName("���ͺ�");
		//���ù�ϵ
		car.setWheel(wheel);
		
		//�������
		session.save(car);
		tx.commit();
		session.close();
	}
	
}
