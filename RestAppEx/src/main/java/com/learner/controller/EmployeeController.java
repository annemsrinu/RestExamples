/**
 * 
 */
package com.learner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.learner.Model.Employee;
import com.learner.dao.EmployeeDAO;

/**
 * @author DELL
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDAO employeeDao;

	@GetMapping(value = "/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeDao.getAllEmployee();

		if (employees == null || employees.isEmpty()) {
			return new ResponseEntity("No Data Found!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(employees, HttpStatus.OK);
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee emp,UriComponentsBuilder ucBuilder) {

		employeeDao.addEmployee(emp);
		return new ResponseEntity("Employee added !", HttpStatus.CREATED);

	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee emp) {
		
		Employee currentEmp = employeeDao.findEmp(id);

		if (currentEmp == null) {
			System.out.println("emp with id " + id + " not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}

		currentEmp.setFirstName(emp.getFirstName());
		currentEmp.setLastName(emp.getLastName());
		currentEmp.setId(emp.getId());
		currentEmp.setEmail(emp.getEmail());

		return new ResponseEntity<Employee>(currentEmp, HttpStatus.OK);
	}


	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Employee>> deleteEmp(
			@PathVariable("id") Integer id){
		System.out.println();
		List<Employee> emps=employeeDao.deleteEmp(id);
		
		if(emps==null) {
			return new ResponseEntity("Sorry! data found!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}
}
