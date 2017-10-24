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
public class EmployeeTest4 {

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
	public void testCache(){	
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		//һ�������ʹ��
		Employee employee = null;
		employee = (Employee) session.get(Employee.class, 4);
		//��ִ��һ�β�ѯ������ʱ��ִ�еڶ��β�ѯ�������ȼ�黺�����Ƿ������ݣ�
		//��������ݾͲ���ѯ���ݿ⣬ֱ�Ӵӻ����л�ȡ����
		employee = (Employee) session.get(Employee.class, 4);
		
		
		//�ύ����
		tx.commit();
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
	
	@Test
	public void Cache(){	
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		//һ�������ʹ��
		Employee employee = null;
		employee = (Employee) session.get(Employee.class, 4);
		//ʹ����һ�����棬ִ����һ��������䣬name�Ѿ������1��������2
		employee.setEmployeeName("���1");
		employee.setEmployeeName("���2");
		
		
		//�ύ����
		tx.commit();//�˾��൱��ִ����session.flush(),ˢ���˻���
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
	
	@Test
	public void flushTest(){	
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		//һ�������ʹ��
		Employee employee = null;
		employee = (Employee) session.get(Employee.class, 4);
		employee.setEmployeeName("���1");
		//�������������ݿ�ͬ����
		//��һ��ͬ����
		session.flush();
		employee.setEmployeeName("���2");
		
		
		//�ύ����
		//�ύ���񣬵ڶ���ͬ��
		tx.commit();//�˾��൱��ִ����session.flush(),ˢ���˻���
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
	
	@Test
	public void clearTest(){	
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		//һ�������ʹ��
		Employee employee = null;
		employee = (Employee) session.get(Employee.class, 4);
		//���һ�����������еĶ���
		//������ж���
		session.clear();
		
		employee = (Employee) session.get(Employee.class, 4);
		
		
		//�ύ����
		//�ύ����ͬ��
		tx.commit();//�˾��൱��ִ����session.flush(),ˢ���˻���
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
	
	@Test
	public void evictTest(){	
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		//һ�������ʹ��
		Employee employee = null;
		employee = (Employee) session.get(Employee.class, 4);
		//���һ��������ָ���Ķ���
		//���ָ���Ķ���
		session.evict(employee);
		
		employee = (Employee) session.get(Employee.class, 4);
		
		
		//�ύ����
		//�ύ����ͬ��
		tx.commit();//�˾��൱��ִ����session.flush(),ˢ���˻���
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
}
