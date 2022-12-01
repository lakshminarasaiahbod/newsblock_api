package com.newsblock.api.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newsblock.api.model.Articles;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Integer> {

	@Query("SELECT a FROM Articles a WHERE a.isactive = 1 and a.id IN :listOfIds ORDER BY a.createdon DESC")
	List<Articles> getByList(List<Integer> listOfIds);

	@Query("SELECT a FROM Articles a WHERE a.isactive = 1 and a.id =:id ORDER BY a.createdon DESC")
	Articles findByIdActive(int id);
	
	@Query("SELECT a FROM Articles a WHERE a.isactive = 1 ORDER BY a.createdon DESC")
	List<Articles> findByDateDesc();

}