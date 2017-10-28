package com.bie.lesson10.extend01;

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
		
		/*//猫
		Cat cat = new Cat();
		cat.setAnimalName("大花猫");
		cat.setCatchMouse("不抓老鼠.....");
		//保存
		session.save(cat);*/
		
		//获取数据操作
		//获取时候注意，当写hql查询的使用，通过父类查询必须写上类的全名路径。
		Query query = session.createQuery(" from com.bie.lesson10.extend01.Animal ");
		List<Animal> list = query.list();
		System.out.println(list);
		
		//提交事务
		tx.commit();
		session.close();
	}
	
}
