/**
 * 
 */
package com.newsblock.api.services;

import java.util.LinkedHashMap;
import java.util.List;

import com.newsblock.api.model.Articles;
import com.newsblock.api.model.dto.Article;

/**
 * @author sravanpasunoori
 *
 */


public interface ArticleService {

	LinkedHashMap<String, Object> getArticles(int category, String user_token,int limit);

	Article getArticleData(int id,String user_token);

}
