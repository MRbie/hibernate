package com.bie.lesson03;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:别先生 
* @date Date:2017年10月15日 下午8:52:12 
*
*
*/
public class CompositeTest {

	
	@Test
	public void test(){
		Session sesion = HibernateUtils.getSesion();
		Transaction tx = sesion.beginTransaction();
	
		CompositeKeys key = new CompositeKeys();
		key.setName("张三");
		key.setNumber("123456");
		
		User user = new User();
		user.setId(1);
		user.setKey(key);
		
		sesion.save(user);
		
		//提交事务
		tx.commit();
		//关闭session
		HibernateUtils.closeSession();
	}
}
