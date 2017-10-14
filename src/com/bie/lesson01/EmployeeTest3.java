package com.bie.lesson01;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

/** 
* @author  Author:别先生 
* @date Date:2017年10月14日 下午12:15:42 
*
*
*/
public class EmployeeTest3 {

	private static SessionFactory sf;
	static{
		//获取加载配置文件的管理类对象
		//Configuration config = new Configuration();
		//默认加载src/hibernate.cfg.xml
		//config.configure();
		//创建session工厂对象
		//sf = config.buildSessionFactory();
		
		//快速创建session工厂对象
		sf = new Configuration().configure().buildSessionFactory();
	}
		
	//查询的方法
	@Test
	public void testQuery(){	
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//执行查询操作
		Query query = session.createQuery(" from Employee ");
		List<Employee> list = query.list();
		System.out.println(list);
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
	
	//查询的方法
	@Test
	public void testCriteria(){	
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//完全的面向对象的查询
		Criteria criteria = session.createCriteria(Employee.class);
		//添加查询条件
		criteria.add(Restrictions.eq("employeeId", 1));
		
		//查询全部，没有sql语句
		List<Employee> list = criteria.list();
		System.out.println(list);
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
		
	
	//查询的方法
	@Test
	public void testSql(){	
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//本地sql查询
		SQLQuery sql = session.createSQLQuery("select * from employee ");
		sql.addEntity(Employee.class);
		
		//查询全部，没有sql语句
		List<Employee> list = sql.list();
		System.out.println(list);
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
	
}
