package com.newsblock.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newsblock.api.model.Articles;
import com.newsblock.api.model.ArticletoCategory;

@Repository
public interface ArticletoCategoryRepository extends JpaRepository<ArticletoCategory, Integer> {

	@Query("SELECT ac FROM ArticletoCategory ac WHERE ac.isactive = 1 and ac.categoryid =:categoryid ORDER BY ac.createdon DESC")
	List<ArticletoCategory> findByCategory(int categoryid);

	@Query("SELECT ac FROM ArticletoCategory ac WHERE ac.isactive = 1 and ac.articleid =:id ORDER BY ac.createdon DESC")
	List<ArticletoCategory> findByArticleId(int id);

}