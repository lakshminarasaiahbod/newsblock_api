package com.newsblock.api.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

public class Article implements Serializable {

	private static final long serialVersionUID = 1L;

	public int id;

	public String title;

	public String author;

	public String summary;

	public String ref_img;

	@Expose(serialize = false)
	public Timestamp sourcepublished;

	public String source_link;

	@Expose(serialize = false)
	public Timestamp createdon;

	public int viewcount;

	public String category;

	@Expose(serialize = false)
	public Timestamp updatedon;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRef_img() {
		return ref_img;
	}

	public void setRef_img(String ref_img) {
		this.ref_img = ref_img;
	}

	public Timestamp getSourcepublished() {
		return sourcepublished;
	}

	public void setSourcepublished(Timestamp sourcepublished) {
		this.sourcepublished = sourcepublished;
	}

	public String getSource_link() {
		return source_link;
	}

	public void setSource_link(String source_link) {
		this.source_link = source_link;
	}

	public Timestamp getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Timestamp createdon) {
		this.createdon = createdon;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Timestamp getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(Timestamp updatedon) {
		this.updatedon = updatedon;
	}

}
