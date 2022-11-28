package com.newsblock.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newsblock.api.model.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {

	@Query("SELECT c FROM Categories c WHERE c.isactive = 1")
	List<Categories> findActive();

	@Query("SELECT c FROM Categories c WHERE c.isactive = 1 and c.id =:id")
	List<Categories> findByIdActive(int id);

}