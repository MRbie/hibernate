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

	//保存，部门方，一的一方维护
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
		session.save(employee1);
		session.save(employee2);
		session.save(dept);//保存部门，部门下的所有员工
		
		//提交事务
		tx.commit();
		//关闭session
		HibernateUtils.closeSession();
	}
	
	//保存，员工方，多的一方维护
	//一对多的映射，多的一方进行维护比较好，少生成更新的sql语句
	@Test
	public void testEmployee(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//部门信息
		Dept dept = new Dept();
		dept.setDeptName("资源部");
		
		
		//员工信息
		Employee employee1 = new Employee();
		employee1.setEmpName("张三2");
		employee1.setSalary(3000);
		
		Employee employee2 = new Employee();
		employee2.setEmpName("李四2");
		employee2.setSalary(4000);
		
		//处理部门和员工之间的关系
		//dept.getEmps().add(employee1);
		//dept.getEmps().add(employee2);
		
		//通过员工维护与部门之间的关系
		//从员工的一方设置好部门的信息【推荐，在一对多和多对一的关联关系中，
		//保存数据最好是通过多对一来维护关系，
		//这样可以减少update语句的生成，从而提高hibernate的利用效率
		employee1.setDept(dept);
		employee2.setDept(dept);
		
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
