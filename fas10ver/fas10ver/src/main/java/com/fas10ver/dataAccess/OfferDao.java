package com.fas10ver.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas10ver.entities.Offer;

public interface OfferDao extends JpaRepository<Offer, Integer>{

//	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	List<Offer> findByBusiness_Id(int id);
	List<Offer> findByApprovalStatusFalse();
}
