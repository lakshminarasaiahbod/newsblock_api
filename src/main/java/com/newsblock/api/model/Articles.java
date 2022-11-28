package com.newsblock.api.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.newsblock.api.model.dto.Article;

@Entity
@Table(name = "articles")
public class Articles implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;

	public String title;

	public String author;

	public String description;

	public String image;

	@Expose(serialize = false)
	public Timestamp sourcepublished;

	public String content;

	public String source;

	@Expose(serialize = false)
	public Timestamp createdon;

	public int viewcount;

	public int isactive;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Timestamp getSourcepublished() {
		return sourcepublished;
	}

	public void setSourcepublished(Timestamp sourcepublished) {
		this.sourcepublished = sourcepublished;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
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

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public Article getDTO() {

		Article articleDTO = new Article();

		articleDTO.setId(this.id);
		articleDTO.setTitle(this.title);
		articleDTO.setAuthor(this.author);
		articleDTO.setSummary(this.content);
		articleDTO.setRef_img(this.image);
		articleDTO.setSourcepublished(this.sourcepublished);
		articleDTO.setSource_link(this.source);
		articleDTO.setCreatedon(this.createdon);
		articleDTO.setViewcount(this.viewcount);
		articleDTO.setUpdatedon(this.updatedon);

		return articleDTO;
	}

}
