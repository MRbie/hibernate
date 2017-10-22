package com.bie.lesson05;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:������ 
* @date Date:2017��10��21�� ����3:49:38 
* 
* 1���ܽ᣺��һ�Զ�����һ�Ĺ�����ϵ�У�����������õ���ͨ�����һ����ά����ϵ���������Լ���
* uodate�������ɣ��Ӷ��ύhibernate��ִ��Ч�ʡ�
* 
* 2������һ�Զ�����һ�����ֽ���˫����������߽���˫����һ����һ�Զࡣ
* ���ֻ����һ�Զ࣬���ֽ�������һ�Զࡣ���ֻ���ö��һ�����ֽ���������һ��
* ע�⣺������һ������һ����ӵ��ά��������ϵ��Ȩ�ޡ�
*/
public class ManyToManyTest {

	//���棬���ŷ���һ��һ��ά��
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
		session.save(employee1);
		session.save(employee2);
		session.save(dept);//���沿�ţ������µ�����Ա��
		
		//�ύ����
		tx.commit();
		//�ر�session
		HibernateUtils.closeSession();
	}
	
	//���棬Ա���������һ��ά��
	//һ�Զ��ӳ�䣬���һ������ά���ȽϺã������ɸ��µ�sql���
	@Test
	public void testEmployee(){
		Session session = HibernateUtils.getSesion();
		//��������
		Transaction tx = session.beginTransaction();
		
		//������Ϣ
		Dept dept = new Dept();
		dept.setDeptName("��Դ��");
		
		
		//Ա����Ϣ
		Employee employee1 = new Employee();
		employee1.setEmpName("����2");
		employee1.setSalary(3000);
		
		Employee employee2 = new Employee();
		employee2.setEmpName("����2");
		employee2.setSalary(4000);
		
		//�����ź�Ա��֮��Ĺ�ϵ
		//dept.getEmps().add(employee1);
		//dept.getEmps().add(employee2);
		
		//ͨ��Ա��ά���벿��֮��Ĺ�ϵ
		//��Ա����һ�����úò��ŵ���Ϣ���Ƽ�����һ�Զ�Ͷ��һ�Ĺ�����ϵ�У�
		//�������������ͨ�����һ��ά����ϵ��
		//�������Լ���update�������ɣ��Ӷ����hibernate������Ч��
		employee1.setDept(dept);
		employee2.setDept(dept);
		
		//�������
		session.save(dept);//���沿�ţ������µ�����Ա��
		session.save(employee1);
		session.save(employee2);
		
		//�ύ����
		tx.commit();
		//�ر�session
		HibernateUtils.closeSession();
	}
	
	//��ȡ����
	//������һ������ͨ����һ�����в���
	@Test
	public void getMessage(){
		Session session = HibernateUtils.getSesion();
		//��������
		Transaction tx = session.beginTransaction();
		
		//ͨ�����ŷ���ȡ����һ��
		Dept dept = (Dept) session.get(Dept.class, 1);
		System.out.println(dept.getDeptName());
		//�����أ�ʹ�õ�ʱ���ٲ�ѯ��
		//System.out.println(dept.getEmps());
		
		//ͨ��Ա��������ȡ���ŷ�
		Employee employee = (Employee) session.get(Employee.class, 1);
		System.out.println(employee.getEmpName());
		System.out.println(employee.getDept().getDeptName());
		
		//�ύ����
		tx.commit();
		//�ر�session
		HibernateUtils.closeSession();
	}
}
