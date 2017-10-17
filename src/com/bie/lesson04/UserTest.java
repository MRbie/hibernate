package com.bie.lesson04;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:������ 
* @date Date:2017��10��17�� ����8:49:47 
*
* ����
*/
public class UserTest {

	@Test
	public void test(){
		//��ȡ��session
		Session sesion = HibernateUtils.getSesion();
		//��������
		sesion.beginTransaction();
		
		Set<String> addressSet = new HashSet<String>();
		addressSet.add("����");
		addressSet.add("֣��");
		
		User user = new User();
		user.setUserName("�����");
		user.setAddress(addressSet);
		
		//����
		sesion.save(user);
		
		//�ύ����
		sesion.getTransaction().commit();
		//�ر�session
		HibernateUtils.closeSession();
	}

	
}
