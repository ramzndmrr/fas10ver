package com.fas10ver.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas10ver.business.abstracts.EmployeeService;
import com.fas10ver.dataAccess.EmployeeDao;
import com.fas10ver.entities.Employee;
import com.fas10ver.entities.dtos.employeDto.EmployeeDtoForCreate;
import com.fas10ver.entities.models.ApiResponse;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	private ModelMapper modelMapper;
	
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, ModelMapper modelMapper) {
		this.employeeDao = employeeDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public ApiResponse<List<Employee>> getAll() {
		List<Employee> list = employeeDao.findAll();
		return ApiResponse.default_OK(list);
	}

	@Override
	public ApiResponse<Employee> add(EmployeeDtoForCreate createRequest) {
		Employee employee = modelMapper.map(createRequest, Employee.class);
		employeeDao.save(employee);
		return ApiResponse.default_CREATED(employee);
	}

}
