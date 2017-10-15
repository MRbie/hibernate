package com.bie.lesson02.crud.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bie.lesson02.crud.po.Employee;


/** 
* @author  Author:别先生 
* @date Date:2017年10月14日 下午10:36:46 
*
* 工具类
*/
public class HibernateUtils {

	//加载映射文件的两种方式：<mapping resource="com/bie/lesson02/crud/po/employee.hbm.xml"/>
	
	private static SessionFactory sf;
	static{
		//加载主配置文件，并且创建session工厂
		sf = new Configuration()
				.configure()
				//.addClass(Employee.class)//便于测试,会自动加载映射文件:employee.hbm.xml
				.buildSessionFactory();
	}
	
	//获取到session,创建session对象
	public static Session getSesion(){
		Session session = sf.openSession();
		return session;
	}
	
	//关闭session
	public static void closeSession(){
		//获取到session对象
		Session session = sf.openSession();
		//然后关闭session对象
		session.close();
	}
}
