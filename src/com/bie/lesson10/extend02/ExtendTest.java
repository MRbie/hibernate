package com.bie.lesson10.extend02;

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
		
		//è
		Cat cat = new Cat();
		cat.setAnimalName("��è");
		cat.setCatchMouse("��ץ����.....");
		
		
		//����
		Monkey monkey = new Monkey();
		monkey.setAnimalName("С����");
		monkey.setEatBanana("�Դ��㽶");
		
		//����
		session.save(cat);
		session.save(monkey);
		
		//�ύ����
		tx.commit();
		session.close();
	}
	
}
