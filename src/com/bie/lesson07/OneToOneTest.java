package com.bie.lesson07;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:别先生 
* @date Date:2017年10月28日 下午7:46:26 
*
*
*/
public class OneToOneTest {

	@Test
	public void OneToOne(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		//执行事务
		
		//用户
		User user = new User();
		user.setUserName("张三");
		
		//身份证号码
		IdCard idCard = new IdCard();
		idCard.setCardNumber("410725199*********");
		idCard.setPlace("河南省新乡市");
		
		//用户和身份证号码之前的关系
		idCard.setUser(user);
		
		//保存操作,设置了级联操作，用户操作不用保存，如果没有设置级联操作，必须保存用户
		session.save(idCard);
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
	}
	
}
