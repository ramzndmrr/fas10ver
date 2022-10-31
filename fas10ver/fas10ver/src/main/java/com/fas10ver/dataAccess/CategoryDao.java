package com.fas10ver.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas10ver.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
