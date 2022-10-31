package com.fas10ver.business.abstracts;

import java.util.List;

import com.fas10ver.entities.Machine;
import com.fas10ver.entities.dtos.machineDto.MachineDtoForCreate;
import com.fas10ver.entities.dtos.machineDto.MachineDtoForUpdate;
import com.fas10ver.entities.models.ApiResponse;

public interface MachineService {
	
	ApiResponse<List<Machine>> getAll();
	ApiResponse<Machine> add(MachineDtoForCreate forCreate);
	
}
