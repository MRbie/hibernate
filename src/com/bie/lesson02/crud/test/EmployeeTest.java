package com.bie.lesson02.crud.test;

import java.util.List;

import org.junit.Test;

import com.bie.lesson02.crud.dao.EmployeeDao;
import com.bie.lesson02.crud.dao.impl.EmployeeDaoImpl;
import com.bie.lesson02.crud.po.Employee;

/** 
* @author  Author:别先生 
* @date Date:2017年10月14日 下午11:08:54 
*
*
*/
public class EmployeeTest {

	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	@Test
	public void saveTest(){
		Employee employee = new Employee();
		employee.setEmployeeName("礼拜7");
		employee.setEmployeePassword("123456");
		employee.setEmployeeEmail("123456@qq.com");
		employee.setEmployeePhone("123456");
		
		//保存的方法
		employeeDao.save(employee);
		
	}
	
	@Test
	public void deleteTest(){
		employeeDao.delete(3);
	}
	
	@Test
	public void updateTest(){
		Employee employee = new Employee();
		employee.setEmployeeId(4);
		employee.setEmployeeName("礼拜7");
		employee.setEmployeePassword("123456");
		employee.setEmployeeEmail("123456@qq.com");
		employee.setEmployeePhone("123456");
		employeeDao.update(employee);
	}
	
	@Test
	public void selectTest(){
		//查询全部
		List<Employee> all = employeeDao.getAll();
		System.out.println(all);
	}
	
	@Test
	public void selectByIdTest(){
		Employee employee = employeeDao.findById(1);
		System.out.println(employee);
	}
	
	@Test
	public void selectByNameTest(){
		List<Employee> all = employeeDao.getAll("礼拜");
		System.out.println(all);
	}
	
	@Test
	public void selectByLimitTest(){
		List<Employee> allLimit = employeeDao.getAllLimit(3, 3);
		System.out.println(allLimit);
	}
}
