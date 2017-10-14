package com.bie.lesson01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/** 
* @author  Author:������ 
* @date Date:2017��10��14�� ����12:15:42 
*
*
*/
public class EmployeeTest2 {

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
		
	//����ķ���
	@Test
	public void test(){
		//���������
		Employee employee = new Employee();
		employee.setEmployeeId(2);
		employee.setEmployeeName("����2");
		employee.setEmployeePassword("123456");
		employee.setEmployeeEmail("1748741328@qq.com");
		employee.setEmployeePhone("15236083001");
		
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		//���浽���ݿ�
		session.save(employee);
		//�ύ����
		tx.commit();
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
	
	//�޸ĵķ���
	@Test
	public void testUpdate(){
		//���������
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setEmployeeName("����");
		employee.setEmployeePassword("123456");
		employee.setEmployeeEmail("1748741328@qq.com");
		employee.setEmployeePhone("15236083001");
		
		
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		//ִ�в��������±���д���������������ֶζ���Ҫ����ֵ
		session.update(employee);
		
		//�ύ����
		tx.commit();
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
	
	//����������ѯ
	@Test
	public void testGet(){
		//Employee employee = new Employee();
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		//����������ѯ
		Employee employee = (com.bie.lesson01.Employee) session.get(Employee.class, 1);
		Employee employee2 = (com.bie.lesson01.Employee) session.load(Employee.class, 1);
		
		System.out.println(employee == employee2);
		
		/*if(employee != null){
			session.update(employee);
		}*/
		
		//�ύ����
		tx.commit();
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
		
	}
	
	//������߸��µķ�����û������������ִ�б��棬������������ִ�и��²������������
	//���������ڣ��ͱ���
	@Test
	public void testSaveOrUpdate(){
		//���������
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setEmployeeName("����2");
		employee.setEmployeePassword("123456");
		employee.setEmployeeEmail("1748741328@qq.com");
		employee.setEmployeePhone("15236083001");
		//����session������һ���Ự�������ݿ����ӵĻỰ
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		//������߸���
		session.saveOrUpdate(employee);
		
		//�ύ����
		tx.commit();
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
	
	//ɾ���ķ���
	@Test
	public void testDelete(){
		//��ȡ��session
		Session session = sf.openSession();
		//��������
		Transaction tx = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEmployeeId(2);
		//ɾ���Ĳ���
		session.delete(employee );
		
		//�ύ����
		tx.commit();
		//�ر�session
		session.close();
		//�رչ���
		sf.close();
	}
}
