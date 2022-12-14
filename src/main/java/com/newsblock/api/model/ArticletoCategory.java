package com.newsblock.api.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "articletocategory")
public class ArticletoCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	public int articleid;
	
	public int categoryid;
	
	public int isactive;
	
	@Expose(serialize = false)
	public Timestamp createdon;
	
	@Expose(serialize = false)
	public Timestamp updatedon;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticleid() {
		return articleid;
	}

	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public Timestamp getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}

	public Timestamp getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(Timestamp updatedon) {
		this.updatedon = updatedon;
	}

	


	

}
