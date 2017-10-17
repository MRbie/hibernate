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

	
}
