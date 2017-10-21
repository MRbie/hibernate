package com.bie.lesson05;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:别先生 
* @date Date:2017年10月21日 下午3:49:38 
*
*
*/
public class ManyToManyTest {

	//保存，部门方
	@Test
	public void test(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//部门信息
		Dept dept = new Dept();
		dept.setDeptName("开发部");
		
		
		//员工信息
		Employee employee1 = new Employee();
		employee1.setEmpName("张三");
		employee1.setSalary(3000);
		
		Employee employee2 = new Employee();
		employee2.setEmpName("李四");
		employee2.setSalary(4000);
		
		//处理部门和员工之间的关系
		dept.getEmps().add(employee1);
		dept.getEmps().add(employee2);
		
		//保存操作
		session.save(dept);//保存部门，部门下的所有员工
		session.save(employee1);
		session.save(employee2);
		
		//提交事务
		tx.commit();
		//关闭session
		HibernateUtils.closeSession();
	}
	
	
}
