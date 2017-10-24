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
public class EmployeeTest4 {

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
	public void testCache(){	
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//一级缓存的使用
		Employee employee = null;
		employee = (Employee) session.get(Employee.class, 4);
		//当执行一次查询操作的时候，执行第二次查询操作，先检查缓存中是否有数据，
		//如果有数据就不查询数据库，直接从缓存中获取数据
		employee = (Employee) session.get(Employee.class, 4);
		
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
	
	@Test
	public void Cache(){	
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//一级缓存的使用
		Employee employee = null;
		employee = (Employee) session.get(Employee.class, 4);
		//使用了一级缓存，执行了一条更新语句，name已经由礼拜1变成了礼拜2
		employee.setEmployeeName("礼拜1");
		employee.setEmployeeName("礼拜2");
		
		
		//提交事务
		tx.commit();//此句相当于执行了session.flush(),刷新了缓存
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
	
	@Test
	public void flushTest(){	
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//一级缓存的使用
		Employee employee = null;
		employee = (Employee) session.get(Employee.class, 4);
		employee.setEmployeeName("礼拜1");
		//缓存数据与数据库同步。
		//第一次同步，
		session.flush();
		employee.setEmployeeName("礼拜2");
		
		
		//提交事务
		//提交事务，第二次同步
		tx.commit();//此句相当于执行了session.flush(),刷新了缓存
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
	
	@Test
	public void clearTest(){	
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//一级缓存的使用
		Employee employee = null;
		employee = (Employee) session.get(Employee.class, 4);
		//清空一级缓存中所有的对象；
		//清空所有对象
		session.clear();
		
		employee = (Employee) session.get(Employee.class, 4);
		
		
		//提交事务
		//提交事务，同步
		tx.commit();//此句相当于执行了session.flush(),刷新了缓存
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
	
	@Test
	public void evictTest(){	
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//一级缓存的使用
		Employee employee = null;
		employee = (Employee) session.get(Employee.class, 4);
		//清空一级缓存中指定的对象；
		//清空指定的对象
		session.evict(employee);
		
		employee = (Employee) session.get(Employee.class, 4);
		
		
		//提交事务
		//提交事务，同步
		tx.commit();//此句相当于执行了session.flush(),刷新了缓存
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
}
