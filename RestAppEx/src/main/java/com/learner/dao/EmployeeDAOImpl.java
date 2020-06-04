/**
 * 
 */
package com.learner.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Repository;

import com.learner.Model.Employee;

/**
 * @author DELL
 *
 */
@Repository("empDao")
@XmlRootElement(name = "employees")
public class EmployeeDAOImpl implements EmployeeDAO {

	private static List<Employee> employees = new ArrayList<>();

	static {
		employees.add(new Employee(1, "Garreston", "Patric", "patricG@gmail.com"));
		employees.add(new Employee(2, "James", "David", "jamesD@gmail.com"));
		employees.add(new Employee(3, "Steven", "King", "StevenK@gmail.com"));
	}

	@Override
	public List<Employee> getAllEmployee() {

		return employees;
	}

	@Override
	public Employee findEmp(Integer id) {

		for (Employee emp : employees) {
			if (emp.getId() == id)
				return emp;
		}
		return null;
	}

	@Override
	public List<Employee> deleteEmp(Integer id) {

		boolean flag = false;
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			Employee employee = iterator.next();
			if (employee.getId() == id) {
				flag = true;
				iterator.remove();
				break;
			}
		}
		if (flag)
			return employees;
		else
			return null;
	}

	@Override
	public void addEmployee(Employee emp) {
		employees.add(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {

		int id = employees.indexOf(emp);
		employees.set(id, emp);
	}

}
