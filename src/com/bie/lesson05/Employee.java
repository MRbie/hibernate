package com.bie.lesson05;
/** 
* @author  Author:������ 
* @date Date:2017��10��21�� ����3:03:28 
*
* Ա����ʵ����
*/
public class Employee {

	private int empId;//Ա�����
	private String empName;//Ա������
	private double salary;//Ա��н��
	//�����һ��Ա���Ͳ���֮��Ĺ�ϵ��һ��Ա����Ӧһ������
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
