package com.bie.lesson01;
/** 
* @author  Author:������ 
* @date Date:2017��10��14�� ����11:46:44 
*
* Ա����ʵ����
*/
public class Employee {

	private int employeeId;//Ա�����
	private String employeeName;//Ա������
	private String employeePassword;//Ա������
	private String employeeEmail;//Ա������
	private String employeePhone;//Ա���绰
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePassword="
				+ employeePassword + ", employeeEmail=" + employeeEmail + ", employeePhone=" + employeePhone + "]";
	}
	
	
	
}
