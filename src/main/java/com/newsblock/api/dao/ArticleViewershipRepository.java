package com.newsblock.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newsblock.api.model.ArticleViewership;

@Repository
public interface ArticleViewershipRepository extends JpaRepository<ArticleViewership, Integer> {

}