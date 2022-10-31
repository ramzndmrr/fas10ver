package com.fas10ver.business.concretes;

import java.util.List;

import javax.crypto.Mac;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fas10ver.business.abstracts.BrandService;
import com.fas10ver.business.abstracts.MachineService;
import com.fas10ver.dataAccess.MachineDao;
import com.fas10ver.entities.Brand;
import com.fas10ver.entities.Machine;
import com.fas10ver.entities.dtos.machineDto.MachineDtoForCreate;
import com.fas10ver.entities.dtos.machineDto.MachineDtoForUpdate;
import com.fas10ver.entities.models.ApiResponse;


@Service
public class MachineManager implements MachineService {
	
	private MachineDao machineDao;
	private ModelMapper modelMapper;
	private BrandService brandService;

	@Autowired
	public MachineManager(MachineDao machineDao, ModelMapper modelMapper,BrandService brandService) {
		this.machineDao = machineDao;
		this.modelMapper = modelMapper;
		this.brandService=brandService;
	}

	@Override
	public ApiResponse<List<Machine>> getAll() {
		List<Machine> list = machineDao.findAll();		
		return ApiResponse.default_OK(list);
	}

	@Override
	public ApiResponse<Machine> add(MachineDtoForCreate forCreate) {
		
	    Brand brand = brandService.getOneBrand(forCreate.getBrandId()).getData();
		Machine machine = modelMapper.map(forCreate, Machine.class);
		machine.setBrand(brand);
		machine.setType(forCreate.getType());
		machine.setAge(forCreate.getAge());
		machineDao.save(machine);
		return ApiResponse.default_CREATED(machine);
		
	}

}
