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

	@Test
	public void testList(){
		//��ȡ��session
		Session sesion = HibernateUtils.getSesion();
		//��������
		sesion.beginTransaction();
		

		User user = new User();
		user.setUserName("�����2");
		user.getAddressList().add("֣��2");
		user.getAddressList().add("����2");
		
		//����
		sesion.save(user);
		
		//�ύ����
		sesion.getTransaction().commit();
		//�ر�session
		HibernateUtils.closeSession();
	}
	
	@Test
	public void testMap(){
		//��ȡ��session
		Session sesion = HibernateUtils.getSesion();
		//��������
		sesion.beginTransaction();
		

		User user = new User();
		user.setUserName("�����3");
		user.getAddressMap().put("����3", "������3");
		user.getAddressMap().put("�Ϻ�3", "�Ϻ���3");
		
		//����
		sesion.save(user);
		
		//�ύ����
		sesion.getTransaction().commit();
		//�ر�session
		HibernateUtils.closeSession();
	}
	
	
	@Test
	public void testGetList(){
		//��ȡ��session
		Session sesion = HibernateUtils.getSesion();
		//��������
		sesion.beginTransaction();
		
		//��ѯ
		//��ʱ����
		User user = (User) sesion.get(User.class, 2);
		System.out.println(user.getUserId());
		System.out.println(user.getUserName());
		//����ѯ�û���ͬʱ���Ի�ȡ�û�������list���ϵ����ݣ���Ϊ����ȷ��ӳ��
		//��ʹ�õ����ϵ�ʱ�򣬲������ݿⷢ��ִ�е�sql���(������)
		System.out.println(user.getAddressList());
		
		//�ύ����
		sesion.getTransaction().commit();
		//�ر�session
		HibernateUtils.closeSession();
	}
	
}
