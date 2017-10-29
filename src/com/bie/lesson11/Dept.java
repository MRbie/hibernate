package com.bie.lesson11;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/** 
* @author  Author:别先生 
* @date Date:2017年10月21日 下午3:01:52 
* 部门的实体类
*	关键点，是通过部门实体类维护到员工的实体类
*/
public class Dept implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int deptId;//部门编号
	private String deptName;//部门名称
	//【一对多】部门与员工的对应关系，一个部门对应多个员工
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
	/*public Dept(int deptId, String deptName, Set<Employee> emps) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.emps = emps;
	}
	public Dept(String deptName) {
		super();
		this.deptName = deptName;
	}*/
	
	
}
