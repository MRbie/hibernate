package com.bie.lesson07;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.bie.lesson02.crud.utils.HibernateUtils;

/** 
* @author  Author:������ 
* @date Date:2017��10��28�� ����7:46:26 
*
*
*/
public class OneToOneTest {

	@Test
	public void OneToOne(){
		Session session = HibernateUtils.getSesion();
		//��������
		Transaction tx = session.beginTransaction();
		//ִ������
		
		//�û�
		User user = new User();
		user.setUserName("����");
		
		//���֤����
		IdCard idCard = new IdCard();
		idCard.setCardNumber("410725199*********");
		idCard.setPlace("����ʡ������");
		
		//�û������֤����֮ǰ�Ĺ�ϵ
		idCard.setUser(user);
		
		//�������,�����˼����������û��������ñ��棬���û�����ü������������뱣���û�
		session.save(idCard);
		
		//�ύ����
		tx.commit();
		//�ر�session
		session.close();
	}
	
}
