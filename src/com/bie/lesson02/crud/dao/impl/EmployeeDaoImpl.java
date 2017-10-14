package com.bie.lesson02.crud.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bie.lesson02.crud.dao.EmployeeDao;
import com.bie.lesson02.crud.po.Employee;
import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:别先生 
* @date Date:2017年10月14日 下午10:23:02 
*
*
*/
public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public void save(Employee employee) {
		Session sesion = null;
		Transaction tx = null;
		try {
			//获取到session
			sesion = HibernateUtils.getSesion();
			//开启事务
			tx = sesion.beginTransaction();
			//保存操作
			sesion.save(employee);
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//提交事务
			tx.commit();
			//关闭session
			HibernateUtils.closeSession();
		}
	}

	@Override
	public void delete(Serializable employeeId) {
		Session sesion = null;
		Transaction tx = null;
		try {
			//获取到session
			sesion = HibernateUtils.getSesion();
			//开启事务
			tx = sesion.beginTransaction();
			//删除操作,删除是先根据编号查询出内容，然后将内容删除
			Employee employee = (Employee) sesion.get(Employee.class, employeeId);
			//如果查询的内容不为空，再删除
			if(employee != null){
				sesion.delete(employee);
			}
			
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//提交事务
			tx.commit();
			//关闭session
			HibernateUtils.closeSession();
		}
		
	}

	@Override
	public void update(Employee employee) {
		Session sesion = null;
		Transaction tx = null;
		try {
			//获取到session
			sesion = HibernateUtils.getSesion();
			//开启事务
			tx = sesion.beginTransaction();	
			//修改操作
			sesion.update(employee);
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//提交事务
			tx.commit();
			//关闭session
			HibernateUtils.closeSession();
		}
		
	}

	@Override
	public Employee findById(Serializable employeeId) {
		Session sesion = null;
		Transaction tx = null;
		Employee employee = null;
		try {
			//获取到session
			sesion = HibernateUtils.getSesion();
			//开启事务
			tx = sesion.beginTransaction();
			//根据编号查询操作
			employee = (Employee) sesion.get(Employee.class,employeeId);
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//提交事务
			tx.commit();
			//关闭session
			HibernateUtils.closeSession();
		}
		return employee;
	}

	@Override
	public List<Employee> getAll() {
		Session sesion = null;
		Transaction tx = null;
		List<Employee> list = null;
		try {
			//获取到session
			sesion = HibernateUtils.getSesion();
			//开启事务
			tx = sesion.beginTransaction();
			//查询操作
			Query query = sesion.createQuery("from Employee ");
			//将查询的结果保存到集合中
			list = query.list();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//提交事务
			tx.commit();
			//关闭session
			HibernateUtils.closeSession();
		}
		return list;
	}

	@Override
	public List<Employee> getAll(String employeeName) {
		Session sesion = null;
		Transaction tx = null;
		List<Employee> list = null;
		try {
			//获取到session
			sesion = HibernateUtils.getSesion();
			//开启事务
			tx = sesion.beginTransaction();
			//保存操作
			Query query = sesion.createQuery("from Employee where employeeName=? ");
			//query.setString(1, employeeName);
			query.setParameter(0, employeeName);
			//将查询的结果保存到集合中
			list = query.list();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//提交事务
			tx.commit();
			//关闭session
			HibernateUtils.closeSession();
		}
		return list;
	}

	@Override
	public List<Employee> getAllLimit(int index, int count) {
		Session sesion = null;
		Transaction tx = null;
		List<Employee> list = null;
		try {
			//获取到session
			sesion = HibernateUtils.getSesion();
			//开启事务
			tx = sesion.beginTransaction();
			//查询操作
			Query query = sesion.createQuery("from Employee ");
			//设置分页参数
			query.setFirstResult(count);//查询的起始行
			query.setMaxResults(index);//查询返回的行数
			
			//将查询的结果保存到集合中
			list = query.list();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//提交事务
			tx.commit();
			//关闭session
			HibernateUtils.closeSession();
		}
		return list;
	}

}
