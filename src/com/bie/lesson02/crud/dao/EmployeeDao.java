package com.bie.lesson02.crud.dao;

import java.io.Serializable;
import java.util.List;

import com.bie.lesson02.crud.po.Employee;

/** 
* @author  Author:������ 
* @date Date:2017��10��14�� ����10:22:40 
*
*
*/
public interface EmployeeDao {

	//��������ķ���
	void save(Employee employee);
	//ɾ���ķ���
	void delete(Serializable employeeId);
	//�޸ĵķ���
	void update(Employee employee);
	//��ѯ�ķ���,����������ѯ
	Employee findById(Serializable employeeId);
	//��ѯ����
	List<Employee> getAll();
	//����Ա��������ѯ
	List<Employee> getAll(String employeeName);
	//��ҳ��ѯ
	List<Employee> getAllLimit(int index,int count);
}
