package com.bie.lesson06;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:别先生 
* @date Date:2017年10月22日 下午5:44:21 
*
*
*/
public class TestReallyManyToMany {

	//多对多关系映射，只能通过一方维护另一方，不能重复维护
	@Test
	public void testManyToMany(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//创建员工对象
		Developer developer1 = new Developer();
		developer1.setDeveloperName("张三");
		Developer developer2 = new Developer();
		developer2.setDeveloperName("李四");
		
		
		//创建项目对象
		Projects projects1 = new Projects();
		projects1.setProjectName("OA系统");
		Projects projects2 = new Projects();
		projects2.setProjectName("电商系统");
		
		
		//项目和员工之间的关系
		projects1.getDeveloper().add(developer1);
		projects1.getDeveloper().add(developer2);
		projects2.getDeveloper().add(developer1);
		projects2.getDeveloper().add(developer2);
		
		
		//保存数据
		//先把项目关联的员工保存了
		session.save(developer1);
		session.save(developer2);
		
		//然后把项目关联的员工保存了
		session.save(projects1);
		session.save(projects2);
		
		//提交事务
		tx.commit();
		//关闭session
		HibernateUtils.closeSession();
		
	}
}
