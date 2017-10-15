package com.bie.lesson03;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:������ 
* @date Date:2017��10��15�� ����8:52:12 
*
*
*/
public class CompositeTest {

	
	@Test
	public void test(){
		Session sesion = HibernateUtils.getSesion();
		Transaction tx = sesion.beginTransaction();
	
		CompositeKeys key = new CompositeKeys();
		key.setName("����");
		key.setNumber("123456");
		
		User user = new User();
		user.setId(1);
		user.setKey(key);
		
		sesion.save(user);
		
		//�ύ����
		tx.commit();
		//�ر�session
		HibernateUtils.closeSession();
	}
}
