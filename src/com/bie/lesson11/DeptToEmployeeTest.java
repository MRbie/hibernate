package com.bie.lesson11;

import org.hibernate.Query;
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
public class DeptToEmployeeTest {

	//���棬���ŷ���һ��һ��ά��
	@Test
	public void test(){
		Session session = HibernateUtils.getSesion();
		//��������
		Transaction tx = session.beginTransaction();
		
		//HQL��ѯ
		//ע�⣺ʹ��hql��ѯ��ʱ��auto-import="true"��Ҫ����true.
		//�����false��дhql��ʱ��Ҫָ�����ȫ����
		/*Query query = session.createQuery("from Dept");
		List<Dept> list = query.list();
		for(Dept d : list){
			System.out.println(d.getDeptName());
		}*/
		
		//1:��ѯȫ����
		//Query query2 = session.createQuery("from Dept");
		//Query query3 = session.createQuery("select d from Dept d ");
		
		
		//2:��ѯָ������
		//Query query4 = session.createQuery("select d.deptName from Dept d ");
		
		
		//3:��ѯָ�����з�װΪ����
		//��ѯָ�����У��Զ���װΪ���󣬱���Ҫ�ṩ�������Ĺ�������
		//Query query5 = session.createQuery("select new Dept(deptId,deptName) from Dept d ");
		
		//4:������ѯ������һ�����������������
		//������ѯ��ռλ����ѯ
		/*Query query6 = session.createQuery("select d.deptName from Dept d where d.deptId=? ");
		query6.setParameter(0, 1);
		System.out.println(query6.list());*/
		
		//ģ����ѯ
		/*Query query61 = session.createQuery("from Dept d where d.deptName like ? ");
		query61.setParameter(0, "��%");
		System.out.println(query61.list());*/
		
		//������ѯ����������,��Ҫ�����������
		/*Query query7 = session.createQuery("from Dept d where d.deptId=:id ");
		query7.setParameter("id", 1);
		System.out.println(query7.list());*/
		
		//5:�ۺϺ���
		/*Query query8 = session.createQuery("select count(*) from Dept ");
		//System.out.println(query8.list());
		Long number = (Long) query8.uniqueResult();
		System.out.println(number);*/
		
		//6:�����ѯ
		/*Query query9 = session.createQuery("select e.empId,count(*) from Employee e group by e.dept");
		//System.out.println(query9.list());
		List<Employee> list = query9.list();
		System.out.println(list);*/
		
		//7:���Ӳ�ѯ
		//������
		/*Query query10 = session.createQuery("from Employee e inner join e.dept");
		System.out.println(query10.list());*/
		
		//��������
		/*Query query11 = session.createQuery("from Employee e left join e.dept");
		System.out.println(query11.list());*/
		
		//��������
		/*Query query12 = session.createQuery("from Employee e right join e.dept");
		System.out.println(query12.list());*/
		
		//����������
		//���������ӻὫ�ұ�����ݣ���䵽�������С�
		Query query13 = session.createQuery("from Employee e inner join fetch e.dept");
		System.out.println(query13.list());
		
		//�ύ����
		tx.commit();
		//�ر�session
		HibernateUtils.closeSession();
	}
	
	@Test
	public void HQL_other(){
		Session session = HibernateUtils.getSesion();
		//��������
		Transaction tx = session.beginTransaction();
		
		//HQL���д�������ļ���ȥ
		Query query = session.getNamedQuery("dept_hql");
		query.setParameter(0, 10);
		System.out.println(query.list());
		
		
		tx.commit();
		session.close();
	}
		
}
