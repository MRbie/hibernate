package com.bie.lesson01;
/** 
* @author  Author:别先生 
* @date Date:2017年10月14日 上午11:46:44 
*
* 员工的实体类
*/
public class Employee {

	private int employeeId;//员工编号
	private String employeeName;//员工姓名
	private String employeePassword;//员工密码
	private String employeeEmail;//员工邮箱
	private String employeePhone;//员工电话
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
