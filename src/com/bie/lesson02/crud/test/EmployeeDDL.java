package com.bie.lesson02.crud.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/** 
* @author  Author:������ 
* @date Date:2017��10��15�� ����4:04:26 
*
* �����Զ�����
*/
public class EmployeeDDL {

	@Test
	public void DDL(){
		//�������ù��������
		Configuration config = new Configuration();
		//�����������ļ�
		config.configure();
		
		//�������������
		SchemaExport export = new SchemaExport(config);
		//�Զ�����,��һ�������Ƿ��ڿ���̨��ӡ�ű����ڶ��������Ƿ�ִ�нű�
		export.create(true, true);
	}
	
	
}
