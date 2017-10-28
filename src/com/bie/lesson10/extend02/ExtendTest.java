package com.bie.lesson10.extend02;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:别先生 
* @date Date:2017年10月28日 下午10:21:49 
*
* 
*/
public class ExtendTest {

	@Test
	public void test(){
		Session session = HibernateUtils.getSesion();
		Transaction tx = session.beginTransaction();
		
		//猫
		Cat cat = new Cat();
		cat.setAnimalName("大花猫");
		cat.setCatchMouse("不抓老鼠.....");
		
		
		//猴子
		Monkey monkey = new Monkey();
		monkey.setAnimalName("小猴子");
		monkey.setEatBanana("吃大香蕉");
		
		//保存
		session.save(cat);
		session.save(monkey);
		
		//提交事务
		tx.commit();
		session.close();
	}
	
}
