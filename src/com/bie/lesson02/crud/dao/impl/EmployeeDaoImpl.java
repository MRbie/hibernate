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
* @author  Author:������ 
* @date Date:2017��10��14�� ����10:23:02 
*
*
*/
public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public void save(Employee employee) {
		Session sesion = null;
		Transaction tx = null;
		try {
			//��ȡ��session
			sesion = HibernateUtils.getSesion();
			//��������
			tx = sesion.beginTransaction();
			//�������
			sesion.save(employee);
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//�ύ����
			tx.commit();
			//�ر�session
			HibernateUtils.closeSession();
		}
	}

	@Override
	public void delete(Serializable employeeId) {
		Session sesion = null;
		Transaction tx = null;
		try {
			//��ȡ��session
			sesion = HibernateUtils.getSesion();
			//��������
			tx = sesion.beginTransaction();
			//ɾ������,ɾ�����ȸ��ݱ�Ų�ѯ�����ݣ�Ȼ������ɾ��
			Employee employee = (Employee) sesion.get(Employee.class, employeeId);
			//�����ѯ�����ݲ�Ϊ�գ���ɾ��
			if(employee != null){
				sesion.delete(employee);
			}
			
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//�ύ����
			tx.commit();
			//�ر�session
			HibernateUtils.closeSession();
		}
		
	}

	@Override
	public void update(Employee employee) {
		Session sesion = null;
		Transaction tx = null;
		try {
			//��ȡ��session
			sesion = HibernateUtils.getSesion();
			//��������
			tx = sesion.beginTransaction();	
			//�޸Ĳ���
			sesion.update(employee);
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//�ύ����
			tx.commit();
			//�ر�session
			HibernateUtils.closeSession();
		}
		
	}

	@Override
	public Employee findById(Serializable employeeId) {
		Session sesion = null;
		Transaction tx = null;
		Employee employee = null;
		try {
			//��ȡ��session
			sesion = HibernateUtils.getSesion();
			//��������
			tx = sesion.beginTransaction();
			//���ݱ�Ų�ѯ����
			employee = (Employee) sesion.get(Employee.class,employeeId);
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//�ύ����
			tx.commit();
			//�ر�session
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
			//��ȡ��session
			sesion = HibernateUtils.getSesion();
			//��������
			tx = sesion.beginTransaction();
			//��ѯ����
			Query query = sesion.createQuery("from Employee ");
			//����ѯ�Ľ�����浽������
			list = query.list();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//�ύ����
			tx.commit();
			//�ر�session
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
			//��ȡ��session
			sesion = HibernateUtils.getSesion();
			//��������
			tx = sesion.beginTransaction();
			//�������
			Query query = sesion.createQuery("from Employee where employeeName=? ");
			//query.setString(1, employeeName);
			query.setParameter(0, employeeName);
			//����ѯ�Ľ�����浽������
			list = query.list();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//�ύ����
			tx.commit();
			//�ر�session
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
			//��ȡ��session
			sesion = HibernateUtils.getSesion();
			//��������
			tx = sesion.beginTransaction();
			//��ѯ����
			Query query = sesion.createQuery("from Employee ");
			//���÷�ҳ����
			query.setFirstResult(count);//��ѯ����ʼ��
			query.setMaxResults(index);//��ѯ���ص�����
			
			//����ѯ�Ľ�����浽������
			list = query.list();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			//�ύ����
			tx.commit();
			//�ر�session
			HibernateUtils.closeSession();
		}
		return list;
	}

}
