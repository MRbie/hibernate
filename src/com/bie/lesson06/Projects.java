package com.bie.lesson06;

import java.util.HashSet;
import java.util.Set;

/** 
* @author  Author:������ 
* @date Date:2017��10��22�� ����5:23:34 
*
* ��Զ��ѧϰ����Ŀ��ʵ����
*/
public class Projects {

	private int projectId;//��Ŀ���
	private String projectName;//��Ŀ����
	//��Ŀ����Ķ��Ա��
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
