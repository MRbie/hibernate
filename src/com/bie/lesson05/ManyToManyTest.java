package com.bie.lesson05;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:������ 
* @date Date:2017��10��21�� ����3:49:38 
*
*
*/
public class ManyToManyTest {

	//���棬���ŷ�
	@Test
	public void test(){
		Session session = HibernateUtils.getSesion();
		//��������
		Transaction tx = session.beginTransaction();
		
		//������Ϣ
		Dept dept = new Dept();
		dept.setDeptName("������");
		
		
		//Ա����Ϣ
		Employee employee1 = new Employee();
		employee1.setEmpName("����");
		employee1.setSalary(3000);
		
		Employee employee2 = new Employee();
		employee2.setEmpName("����");
		employee2.setSalary(4000);
		
		//�����ź�Ա��֮��Ĺ�ϵ
		dept.getEmps().add(employee1);
		dept.getEmps().add(employee2);
		
		//�������
		session.save(dept);//���沿�ţ������µ�����Ա��
		session.save(employee1);
		session.save(employee2);
		
		//�ύ����
		tx.commit();
		//�ر�session
		HibernateUtils.closeSession();
	}
	
	
}
