package com.bie.lesson06;

import java.util.HashSet;
import java.util.Set;

/** 
* @author  Author:������ 
* @date Date:2017��10��22�� ����5:24:03 
* 
* ������Ա��ʵ���࣬��Զ��ѧϰ
*/
public class Developer {

	private int developerId;//Ա�����
	private String developerName;//Ա������
	//����Ա������Ķ����Ŀ
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
