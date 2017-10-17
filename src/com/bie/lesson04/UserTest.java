package com.bie.lesson04;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:别先生 
* @date Date:2017年10月17日 下午8:49:47 
*
* 测试
*/
public class UserTest {

	@Test
	public void test(){
		//获取到session
		Session sesion = HibernateUtils.getSesion();
		//开启事务
		sesion.beginTransaction();
		
		Set<String> addressSet = new HashSet<String>();
		addressSet.add("新乡");
		addressSet.add("郑州");
		
		User user = new User();
		user.setUserName("别宏利");
		user.setAddress(addressSet);
		
		//保存
		sesion.save(user);
		
		//提交事务
		sesion.getTransaction().commit();
		//关闭session
		HibernateUtils.closeSession();
	}

	@Test
	public void testList(){
		//获取到session
		Session sesion = HibernateUtils.getSesion();
		//开启事务
		sesion.beginTransaction();
		

		User user = new User();
		user.setUserName("别宏利2");
		user.getAddressList().add("郑州2");
		user.getAddressList().add("北京2");
		
		//保存
		sesion.save(user);
		
		//提交事务
		sesion.getTransaction().commit();
		//关闭session
		HibernateUtils.closeSession();
	}
	
	@Test
	public void testMap(){
		//获取到session
		Session sesion = HibernateUtils.getSesion();
		//开启事务
		sesion.beginTransaction();
		

		User user = new User();
		user.setUserName("别宏利3");
		user.getAddressMap().put("北京3", "北京市3");
		user.getAddressMap().put("上海3", "上海市3");
		
		//保存
		sesion.save(user);
		
		//提交事务
		sesion.getTransaction().commit();
		//关闭session
		HibernateUtils.closeSession();
	}
	
	
	@Test
	public void testGetList(){
		//获取到session
		Session sesion = HibernateUtils.getSesion();
		//开启事务
		sesion.beginTransaction();
		
		//查询
		//及时加载
		User user = (User) sesion.get(User.class, 2);
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
		//当查询用户，同时可以获取用户关联的list集合的数据，因为有正确的映射
		//当使用到集合的时候，才向数据库发送执行的sql语句(懒加载)
		System.out.println(user.getAddressList());
		
		//提交事务
		sesion.getTransaction().commit();
		//关闭session
		HibernateUtils.closeSession();
	}
	
}
