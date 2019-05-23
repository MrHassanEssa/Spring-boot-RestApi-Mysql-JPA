package com.mastercoding.springbootCRUDRESTAPIMYSQL.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercoding.springbootCRUDRESTAPIMYSQL.model.Employee;
import com.mastercoding.springbootCRUDRESTAPIMYSQL.repositry.EmployeeRepositry;
@Service
public class EmployeeDAO {
	@Autowired
	EmployeeRepositry employeeRepositry;
	
	/*save an employee */
	public Employee save(Employee emp) {
		return employeeRepositry.save(emp);
	}
	
	/*get all employees */
	public List<Employee> getAll() {
		return employeeRepositry.findAll();
	}
	
	/*get an employee */
	public Employee findOne(Long empid) {
		return employeeRepositry.getOne(empid);
	}
	
	/*delete an employee */
	public void delete(Employee emp) {
		 employeeRepositry.delete(emp);
	}
}
