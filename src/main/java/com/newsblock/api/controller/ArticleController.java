package com.newsblock.api.controller;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newsblock.api.model.dto.Article;
import com.newsblock.api.services.ArticleService;
import com.newsblock.api.util.CommonResponse;

@RestController
@RequestMapping("/data")
@CrossOrigin
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@RequestMapping(method = RequestMethod.GET, value = "/articles")
	public CommonResponse article(@RequestParam(required = false, defaultValue = "") String user_token,
			@RequestParam(required = false, defaultValue = "0") int category,
			@RequestParam(required = false, defaultValue = "10") int limit) {

		CommonResponse commonResponse = new CommonResponse();
		LinkedHashMap<String, Object> articles = articleService.getArticles(category, user_token, limit);
		commonResponse.setSuccessResponse(articles);
		return commonResponse;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/article")
	public CommonResponse getarticledata(@RequestParam(required = true) int id,
			@RequestParam(required = false, defaultValue = "") String token) {

		CommonResponse commonResponse = new CommonResponse();
		Article article = articleService.getArticleData(id, token);
		commonResponse.setSuccessResponse(article);
		return commonResponse;
	}

}