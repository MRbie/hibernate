package com.bie.lesson06;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:������ 
* @date Date:2017��10��22�� ����5:44:21 
*
*
*/
public class TestReallyManyToMany {

	//��Զ��ϵӳ�䣬ֻ��ͨ��һ��ά����һ���������ظ�ά��
	@Test
	public void testManyToMany(){
		Session session = HibernateUtils.getSesion();
		//��������
		Transaction tx = session.beginTransaction();
		
		//����Ա������
		Developer developer1 = new Developer();
		developer1.setDeveloperName("����");
		Developer developer2 = new Developer();
		developer2.setDeveloperName("����");
		
		
		//������Ŀ����
		Projects projects1 = new Projects();
		projects1.setProjectName("OAϵͳ");
		Projects projects2 = new Projects();
		projects2.setProjectName("����ϵͳ");
		
		
		//��Ŀ��Ա��֮��Ĺ�ϵ
		projects1.getDeveloper().add(developer1);
		projects1.getDeveloper().add(developer2);
		projects2.getDeveloper().add(developer1);
		projects2.getDeveloper().add(developer2);
		
		
		//��������
		//�Ȱ���Ŀ������Ա��������
		session.save(developer1);
		session.save(developer2);
		
		//Ȼ�����Ŀ������Ա��������
		session.save(projects1);
		session.save(projects2);
		
		//�ύ����
		tx.commit();
		//�ر�session
		HibernateUtils.closeSession();
		
	}
}
