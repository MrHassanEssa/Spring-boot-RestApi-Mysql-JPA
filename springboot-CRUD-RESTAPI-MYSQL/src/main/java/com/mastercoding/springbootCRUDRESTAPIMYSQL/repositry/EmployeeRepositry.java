package com.mastercoding.springbootCRUDRESTAPIMYSQL.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastercoding.springbootCRUDRESTAPIMYSQL.model.Employee;

public interface EmployeeRepositry extends JpaRepository<Employee, Long> {

}
