package com.bie.lesson01;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

/** 
* @author  Author:������ 
* @date Date:2017��10��14�� ����12:15:42 
*
*
*/
public class EmployeeTest3 {

	private static SessionFactory sf;
	static{
		//��ȡ���������ļ��Ĺ��������
		//Configuration config = new Configuration();
		//Ĭ�ϼ���src/hibernate.cfg.xml
		//config.configure();
		//����session��������
		//sf = config.buildSessionFactory();
		
		//���ٴ���session��������
		sf = new Configuration().configure().buildSessionFactory();
	}
		
	//��ѯ�ķ���
	@Test
	public void testQuery(){	
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		//ִ�в�ѯ����
		Query query = session.createQuery(" from Employee ");
		List<Employee> list = query.list();
		System.out.println(list);
		
		//�ύ����
		tx.commit();
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
	
	//��ѯ�ķ���
	@Test
	public void testCriteria(){	
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		//��ȫ���������Ĳ�ѯ
		Criteria criteria = session.createCriteria(Employee.class);
		//��Ӳ�ѯ����
		criteria.add(Restrictions.eq("employeeId", 1));
		
		//��ѯȫ����û��sql���
		List<Employee> list = criteria.list();
		System.out.println(list);
		
		//�ύ����
		tx.commit();
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
		
	
	//��ѯ�ķ���
	@Test
	public void testSql(){	
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		//����sql��ѯ
		SQLQuery sql = session.createSQLQuery("select * from employee ");
		sql.addEntity(Employee.class);
		
		//��ѯȫ����û��sql���
		List<Employee> list = sql.list();
		System.out.println(list);
		
		//�ύ����
		tx.commit();
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
	
}
