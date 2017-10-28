package com.bie.lesson10.extend01;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:������ 
* @date Date:2017��10��28�� ����10:21:49 
*
*
*/
public class ExtendTest {

	@Test
	public void test(){
		Session session = HibernateUtils.getSesion();
		Transaction tx = session.beginTransaction();
		
		/*//è
		Cat cat = new Cat();
		cat.setAnimalName("��è");
		cat.setCatchMouse("��ץ����.....");
		//����
		session.save(cat);*/
		
		//��ȡ���ݲ���
		//��ȡʱ��ע�⣬��дhql��ѯ��ʹ�ã�ͨ�������ѯ����д�����ȫ��·����
		Query query = session.createQuery(" from com.bie.lesson10.extend01.Animal ");
		List<Animal> list = query.list();
		System.out.println(list);
		
		//�ύ����
		tx.commit();
		session.close();
	}
	
}
