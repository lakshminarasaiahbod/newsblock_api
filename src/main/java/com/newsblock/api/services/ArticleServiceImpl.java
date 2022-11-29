/**
* 
*/
package com.newsblock.api.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsblock.api.dao.ArticleViewershipRepository;
import com.newsblock.api.dao.ArticlesRepository;
import com.newsblock.api.dao.ArticletoCategoryRepository;
import com.newsblock.api.dao.CategoryRepository;
import com.newsblock.api.dao.UserLoginsRepository;
import com.newsblock.api.model.ArticleViewership;
import com.newsblock.api.model.Articles;
import com.newsblock.api.model.ArticletoCategory;
import com.newsblock.api.model.Categories;
import com.newsblock.api.model.UserLogins;
import com.newsblock.api.model.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticlesRepository articlesRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	UserLoginsRepository userLoginsRepository;

	@Autowired
	ArticletoCategoryRepository articletoCategoryRepository;

	@Autowired
	ArticleViewershipRepository articleViewershipRepository;

	@Override
	public LinkedHashMap<String, Object> getArticles(int category, String user_token, int limit) {

		System.out.println(category);

		List<Categories> categoryObject = categoryRepository.findByIdActive(category);

		int category_id = 0;
		String category_name = "";
		int user_id = 0;

		LinkedHashMap<String, Object> result_map = new LinkedHashMap<>();

		if (categoryObject.size() > 0) {
			category_id = categoryObject.get(0).getId();
			category_name = categoryObject.get(0).getCategoryname();
		}

		List<UserLogins> userLogins = userLoginsRepository.findByActiveToken(user_token);

		if (userLogins.size() > 0) {
			user_id = userLogins.get(0).getId();
		}

		if (user_id == 0) {

			if (category_id != 0) {

				List<ArticletoCategory> listArticle = articletoCategoryRepository.findByCategory(category_id);
				List<Integer> articleIdSorted = new ArrayList<>();
				for (ArticletoCategory articletoCategory : listArticle) {
					articleIdSorted.add(articletoCategory.getArticleid());
				}

				List<Articles> Total_articles = articlesRepository.getByList(articleIdSorted);
				System.out.println(Total_articles);
				List<Object> sorted = new ArrayList<>();
				for (Articles article : Total_articles) {
					LinkedHashMap<String, Object> local_map = new LinkedHashMap<>();
					local_map.put("title", article.getTitle());
					local_map.put("ref_img", article.getImage());
					sorted.add(local_map);
					if (sorted.size() == limit) {
						break;
					}
				}
				result_map.put(category_name, sorted);
				return result_map;

			} else {
				List<Categories> allCategories = categoryRepository.findActive();

				for (Categories categoryObj : allCategories) {

					List<ArticletoCategory> listArticle = articletoCategoryRepository
							.findByCategory(categoryObj.getId());
					List<Integer> articleIdSorted = new ArrayList<>();
					for (ArticletoCategory articletoCategory : listArticle) {
						articleIdSorted.add(articletoCategory.getArticleid());
					}

					List<Articles> Total_articles = articlesRepository.getByList(articleIdSorted);
					List<Object> sorted = new ArrayList<>();
					for (Articles article : Total_articles) {
						LinkedHashMap<String, Object> local_map = new LinkedHashMap<>();
						local_map.put("title", article.getTitle());
						local_map.put("ref_img", article.getImage());
						sorted.add(local_map);
						if (sorted.size() == limit) {
							break;
						}
					}
					result_map.put(categoryObj.getCategoryname(), sorted);

				}
				return result_map;
			}

		} else {

			if (category_id != 0) {

				List<ArticletoCategory> listArticle = articletoCategoryRepository.findByCategory(category_id);
				List<Integer> articleIdSorted = new ArrayList<>();
				for (ArticletoCategory articletoCategory : listArticle) {
					articleIdSorted.add(articletoCategory.getArticleid());
				}

				List<Articles> Total_articles = articlesRepository.getByList(articleIdSorted);
				System.out.println(Total_articles);
				List<Object> sorted = new ArrayList<>();
				for (Articles article : Total_articles) {
					LinkedHashMap<String, Object> local_map = new LinkedHashMap<>();
					local_map.put("title", article.getTitle());
					local_map.put("ref_img", article.getImage());
					sorted.add(local_map);
					if (sorted.size() == limit) {
						break;
					}
				}
				result_map.put(category_name, sorted);
				return result_map;

			} else {
				List<Categories> allCategories = categoryRepository.findActive();

				for (Categories categoryObj : allCategories) {

					List<ArticletoCategory> listArticle = articletoCategoryRepository
							.findByCategory(categoryObj.getId());
					List<Integer> articleIdSorted = new ArrayList<>();
					for (ArticletoCategory articletoCategory : listArticle) {
						articleIdSorted.add(articletoCategory.getArticleid());
					}

					List<Articles> Total_articles = articlesRepository.getByList(articleIdSorted);
					List<Object> sorted = new ArrayList<>();
					for (Articles article : Total_articles) {
						LinkedHashMap<String, Object> local_map = new LinkedHashMap<>();
						local_map.put("title", article.getTitle());
						local_map.put("ref_img", article.getImage());
						sorted.add(local_map);
						if (sorted.size() == limit) {
							break;
						}
					}
					result_map.put(categoryObj.getCategoryname(), sorted);

				}
				return result_map;
			}

		}
	}

	@Override
	public Article getArticleData(int id, String user_token) {

		Articles articles = articlesRepository.findByIdActive(id);
		List<ArticletoCategory> articletoCategory = articletoCategoryRepository.findByArticleId(articles.getId());
		if (articletoCategory.size() > 0) {
			Article articleDTO = articles.getDTO();
			List<Categories> categoryObject = categoryRepository
					.findByIdActive(articletoCategory.get(0).getCategoryid());

			articleDTO.setCategory(categoryObject.get(0).getCategoryname());

			articles.setViewcount(articles.getViewcount() + 1);
			articlesRepository.save(articles);

			List<UserLogins> userLogin = userLoginsRepository.findByToken(user_token);
			if (userLogin.size() > 0) {
				ArticleViewership av = new ArticleViewership();
				av.setArticleid(id);
				av.setUserid(userLogin.get(0).getId());
				av.setIsactive(1);
				Date today = new Date();
				av.setAccessedon(new Timestamp(today.getTime()));
				articleViewershipRepository.save(av);
			}
			return articleDTO;
		} else {
			return null;
		}

	}

	@Override
	public List<Categories> getCategories() {

		List<Categories> listCategories = categoryRepository.findActive();

		return listCategories;
	}
}
