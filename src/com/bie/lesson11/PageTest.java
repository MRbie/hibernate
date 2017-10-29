package com.bie.lesson11;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
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
public class PageTest {

	
	@Test
	public void HQL_other(){
		Session session = HibernateUtils.getSesion();
		//��������
		Transaction tx = session.beginTransaction();
		
		Query q = session.createQuery("from Dept");
		
		//��ȡ���ܼ�·��
		//��ȡ��һ�������Ľ����
		ScrollableResults scroll = q.scroll();
		//���������һ�С�
		scroll.last();
		//�õ��������ܼ�¼��,���ܼ�¼����
		int rowNumber = scroll.getRowNumber() + 1;
		
		//���÷�ҳ����
		q.setFirstResult(0);
		q.setMaxResults(3);
		
		//��ѯ����
		System.out.println(q.list());
		System.out.println(rowNumber);
		
		tx.commit();
		session.close();
	}
		
}
