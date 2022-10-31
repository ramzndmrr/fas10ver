package com.fas10ver.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas10ver.entities.Company;

public interface CompanyDao extends JpaRepository<Company, Integer>{

}
