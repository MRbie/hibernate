package com.bie.lesson05;

import java.util.HashSet;
import java.util.Set;

/** 
* @author  Author:������ 
* @date Date:2017��10��21�� ����3:01:52 
* ���ŵ�ʵ����
*	�ؼ��㣬��ͨ������ʵ����ά����Ա����ʵ����
*/
public class Dept {

	private int deptId;//���ű��
	private String deptName;//��������
	//��һ�Զࡿ������Ա���Ķ�Ӧ��ϵ��һ�����Ŷ�Ӧ���Ա��
	private Set<Employee> emps = new HashSet<Employee>();
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	
	
}