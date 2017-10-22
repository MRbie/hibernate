package com.bie.lesson06;

import java.util.HashSet;
import java.util.Set;

/** 
* @author  Author:别先生 
* @date Date:2017年10月22日 下午5:24:03 
* 
* 开发人员的实体类，多对多的学习
*/
public class Developer {

	private int developerId;//员工编号
	private String developerName;//员工姓名
	//开发员工参与的多个项目
	private Set<Projects> project = new HashSet<Projects>();
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public String getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	public Set<Projects> getProject() {
		return project;
	}
	public void setProject(Set<Projects> project) {
		this.project = project;
	}
	
	
	
}
