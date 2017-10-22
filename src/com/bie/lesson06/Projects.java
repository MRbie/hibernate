package com.bie.lesson06;

import java.util.HashSet;
import java.util.Set;

/** 
* @author  Author:别先生 
* @date Date:2017年10月22日 下午5:23:34 
*
* 多对多的学习，项目的实体类
*/
public class Projects {

	private int projectId;//项目编号
	private String projectName;//项目姓名
	//项目下面的多个员工
	private Set<Developer> developer = new HashSet<Developer>();
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Set<Developer> getDeveloper() {
		return developer;
	}
	public void setDeveloper(Set<Developer> developer) {
		this.developer = developer;
	}
	
	
	
}
