package com.fas10ver.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas10ver.entities.Machine;

public interface MachineDao  extends JpaRepository<Machine, Integer>{

}
