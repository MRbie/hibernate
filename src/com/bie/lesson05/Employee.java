package com.bie.lesson05;
/** 
* @author  Author:别先生 
* @date Date:2017年10月21日 下午3:03:28 
*
* 员工的实体类
*/
public class Employee {

	private int empId;//员工编号
	private String empName;//员工姓名
	private double salary;//员工薪资
	//【多对一】员工和部门之间的关系，一个员工对应一个部门
	private Dept dept;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", dept=" + dept + "]";
	}
	
	
}
