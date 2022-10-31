package com.fas10ver.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas10ver.entities.Business;

public interface BusinessDao extends JpaRepository<Business, Integer> {

}
