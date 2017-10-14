package com.bie.lesson02.crud.dao;

import java.io.Serializable;
import java.util.List;

import com.bie.lesson02.crud.po.Employee;

/** 
* @author  Author:别先生 
* @date Date:2017年10月14日 下午10:22:40 
*
*
*/
public interface EmployeeDao {

	//增，保存的方法
	void save(Employee employee);
	//删除的方法
	void delete(Serializable employeeId);
	//修改的方法
	void update(Employee employee);
	//查询的方法,根据主键查询
	Employee findById(Serializable employeeId);
	//查询所有
	List<Employee> getAll();
	//根据员工姓名查询
	List<Employee> getAll(String employeeName);
	//分页查询
	List<Employee> getAllLimit(int index,int count);
}
