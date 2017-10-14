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
public class EmployeeTest {

	@Test
	public void test(){
		//对象的设置
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setEmployeeName("张三");
		employee.setEmployeePassword("123456");
		employee.setEmployeeEmail("1748741328@qq.com");
		employee.setEmployeePhone("15236083001");
		
		//获取加载配置文件的管理类对象
		Configuration config = new Configuration();
		//默认加载src/hibernate.cfg.xml
		config.configure();
		//创建session工厂对象
		SessionFactory sf = config.buildSessionFactory();
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
}
