package com.spring.hibernate.map1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int pId;
	private String projectName;

	@ManyToMany(mappedBy = "projects")
	private List<Emp> emps;

	public Project(int pId, String projectName, List<Emp> emps) {
		super();
		this.pId = pId;
		this.projectName = projectName;
		this.emps = emps;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

}
