package com.mastercoding.springbootCRUDRESTAPIMYSQL.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercoding.springbootCRUDRESTAPIMYSQL.dao.EmployeeDAO;
import com.mastercoding.springbootCRUDRESTAPIMYSQL.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	@Autowired
	EmployeeDAO dao;
	
//	to save an employee
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return dao.save(emp);
	}
//	get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return dao.getAll();
	}
//	get an employee by id 
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id")Long empid){
		Employee emp=dao.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
//	update an employee by id 
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value="id")Long empid,@Valid @RequestBody Employee empDetails){
		Employee emp=dao.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		emp.setName(empDetails.getName());
		emp.setDest(empDetails.getDest());
		emp.setExper(empDetails.getExper());
		Employee updateEmplyee=dao.save(emp);
		
		return ResponseEntity.ok().body(updateEmplyee);
	}
//	get an employee by id 
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable(value="id")Long empid){
		Employee emp=dao.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		dao.delete(emp);		
		return ResponseEntity.ok().build();
	}
}
