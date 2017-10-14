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
public class EmployeeTest {

	@Test
	public void test(){
		//���������
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setEmployeeName("����");
		employee.setEmployeePassword("123456");
		employee.setEmployeeEmail("1748741328@qq.com");
		employee.setEmployeePhone("15236083001");
		
		//��ȡ���������ļ��Ĺ��������
		Configuration config = new Configuration();
		//Ĭ�ϼ���src/hibernate.cfg.xml
		config.configure();
		//����session��������
		SessionFactory sf = config.buildSessionFactory();
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
}
