package com.fas10ver.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas10ver.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
