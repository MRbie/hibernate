package com.bie.lesson01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/** 
* @author  Author:别先生 
* @date Date:2017年10月14日 下午12:15:42 
*
*
*/
public class EmployeeTest2 {

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
		
	//保存的方法
	@Test
	public void test(){
		//对象的设置
		Employee employee = new Employee();
		employee.setEmployeeId(2);
		employee.setEmployeeName("张三2");
		employee.setEmployeePassword("123456");
		employee.setEmployeeEmail("1748741328@qq.com");
		employee.setEmployeePhone("15236083001");
		
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		//保存到数据库
		session.save(employee);
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
	
	//修改的方法
	@Test
	public void testUpdate(){
		//对象的设置
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setEmployeeName("李四");
		employee.setEmployeePassword("123456");
		employee.setEmployeeEmail("1748741328@qq.com");
		employee.setEmployeePhone("15236083001");
		
		
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//执行操作，更新必须写上主键，其他的字段都需要设置值
		session.update(employee);
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
	
	//根据主键查询
	@Test
	public void testGet(){
		//Employee employee = new Employee();
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//根据主键查询
		Employee employee = (com.bie.lesson01.Employee) session.get(Employee.class, 1);
		Employee employee2 = (com.bie.lesson01.Employee) session.load(Employee.class, 1);
		
		System.out.println(employee == employee2);
		
		/*if(employee != null){
			session.update(employee);
		}*/
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
		
	}
	
	//保存或者更新的方法，没有设置主键，执行保存，有设置主键，执行更新操作，如果设置
	//主键不存在，就报错；
	@Test
	public void testSaveOrUpdate(){
		//对象的设置
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setEmployeeName("李四2");
		employee.setEmployeePassword("123456");
		employee.setEmployeeEmail("1748741328@qq.com");
		employee.setEmployeePhone("15236083001");
		//创建session，代表一个会话，与数据库连接的会话
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//保存或者更新
		session.saveOrUpdate(employee);
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
	
	//删除的方法
	@Test
	public void testDelete(){
		//获取到session
		Session session = sf.openSession();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEmployeeId(2);
		//删除的操作
		session.delete(employee );
		
		//提交事务
		tx.commit();
		//关闭session
		session.close();
		//关闭工厂
		sf.close();
	}
}
