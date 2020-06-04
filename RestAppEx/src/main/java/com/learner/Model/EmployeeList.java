package com.learner.Model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="employees")
public class EmployeeList {
	@XmlElement(name = "employees")
	private List<Employee> employees = new ArrayList<Employee>();

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}