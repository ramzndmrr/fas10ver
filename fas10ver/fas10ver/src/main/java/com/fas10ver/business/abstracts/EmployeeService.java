package com.fas10ver.business.abstracts;

import java.util.List;

import com.fas10ver.entities.Employee;
import com.fas10ver.entities.dtos.employeDto.EmployeeDtoForCreate;
import com.fas10ver.entities.models.ApiResponse;

public interface EmployeeService {

	ApiResponse<List<Employee>> getAll();
	ApiResponse<Employee> add(EmployeeDtoForCreate createRequest);
	}
