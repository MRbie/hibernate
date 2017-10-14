package com.bie.lesson02.crud.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/** 
* @author  Author:������ 
* @date Date:2017��10��14�� ����10:36:46 
*
* ������
*/
public class HibernateUtils {

	private static SessionFactory sf;
	static{
		//�����������ļ������Ҵ���session����
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	//��ȡ��session,����session����
	public static Session getSesion(){
		Session session = sf.openSession();
		return session;
	}
	
	//�ر�session
	public static void closeSession(){
		//��ȡ��session����
		Session session = sf.openSession();
		//Ȼ��ر�session����
		session.close();
	}
}
