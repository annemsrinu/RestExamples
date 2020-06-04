/**
 * 
 */
package com.learner.dao;

import java.util.List;

import com.learner.Model.Employee;

/**
 * @author DELL
 *
 */

public interface EmployeeDAO {

	public List<Employee> getAllEmployee();

	public Employee findEmp(Integer id);

	public List<Employee> deleteEmp(Integer id);

	public void addEmployee(Employee emp);

	public void updateEmployee(Employee emp);

}
