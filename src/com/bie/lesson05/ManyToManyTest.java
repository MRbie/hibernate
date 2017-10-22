package com.bie.lesson05;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:别先生 
* @date Date:2017年10月21日 下午3:49:38 
* 
* 1：总结：在一对多与多对一的关联关系中，保存数据最好的是通过多的一方来维护关系，这样可以减少
* uodate语句的生成，从而提交hibernate的执行效率。
* 
* 2：配置一对多与多对一，这种叫做双向关联，或者叫做双向多对一或者一对多。
* 如果只配置一对多，这种叫做单向一对多。如果只配置多对一，这种叫做单向多对一。
* 注意：配置那一方，那一方才拥有维护关联关系的权限。
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
		dept.setDeptName("22部");
		
		
		//员工信息
		Employee employee1 = new Employee();
		employee1.setEmpName("张三三");
		employee1.setSalary(3000);
		
		Employee employee2 = new Employee();
		employee2.setEmpName("李四四");
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
		dept.setDeptName("测试部");
		
		
		//员工信息
		Employee employee1 = new Employee();
		employee1.setEmpName("张三3");
		employee1.setSalary(3000);
		
		Employee employee2 = new Employee();
		employee2.setEmpName("李四3");
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
	
	//获取数据
	//配置那一方，就通过那一方进行操作
	@Test
	public void getMessage(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//通过部门方获取另外一方
		Dept dept = (Dept) session.get(Dept.class, 2);
		System.out.println(dept.getDeptName());
		//懒加载，使用的时候再查询。
		Set<Employee> emps = dept.getEmps();
		System.out.println(emps);
		
		//通过员工方，获取部门方
		Employee employee = (Employee) session.get(Employee.class, 1);
		System.out.println(employee.getEmpName());
		System.out.println(employee.getDept().getDeptName());
		
		//提交事务
		tx.commit();
		//关闭session
		HibernateUtils.closeSession();
	}
	
	//inverse控制反转对解除关联关系的影响
	@Test
	public void inverseTest(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//通过部门方获取另外一方
		Dept dept = (Dept) session.get(Dept.class, 1);
		//解除关联关系
		//如果有控制权可以解除关联关系，没有控制权不可以解除关联关系。
		dept.getEmps().clear();
		//System.out.println(dept.getDeptName());
		
		
		//提交事务
		tx.commit();
		//关闭session
		HibernateUtils.closeSession();
	}
	
	//inverse控制反转对删除数据的影响
	//是否设置inverse属性，在删除数据中对关联关系的影响？
	@Test
	public void deleteTest(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//直接使用主键删除不可以，因为存在外键引用
		//所以先查询出来再删除操作。
		Dept dept = (Dept) session.get(Dept.class, 1);
		
		//删除数据
		session.delete(dept);
		
		//提交事务
		tx.commit();
		//关闭session
		HibernateUtils.closeSession();
	}
	
	
	//保存，部门方，一的一方维护
	@Test
	public void cascadeTest(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		//部门信息
		Dept dept = new Dept();
		dept.setDeptName("帝王部");
		
		//员工信息
		Employee employee1 = new Employee();
		employee1.setEmpName("李白");
		employee1.setSalary(3000);
		
		Employee employee2 = new Employee();
		employee2.setEmpName("刘备");
		employee2.setSalary(4000);
		
		//处理部门和员工之间的关系
		dept.getEmps().add(employee1);
		dept.getEmps().add(employee2);
		
		//保存操作
		//session.save(employee1);
		//session.save(employee2);
		session.save(dept);//保存部门，部门下的所有员工
		
		//提交事务
		tx.commit();
		//关闭session
		HibernateUtils.closeSession();
	}
	
	
	//保存，部门方，一的一方维护
	@Test
	public void cascadeDeleteTest(){
		Session session = HibernateUtils.getSesion();
		//开启事务
		Transaction tx = session.beginTransaction();
		
		Dept dept = (Dept)session.get(Dept.class, 3);
		
		//删除，级联删除
		session.delete(dept);
		
		//提交事务
		tx.commit();
		//关闭session
		HibernateUtils.closeSession();
	}
		
}
