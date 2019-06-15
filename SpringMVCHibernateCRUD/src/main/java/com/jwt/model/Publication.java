package com.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="publication")
@Component
public class Publication {
	
	@Id
	@Column(name="pubId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pubId;
	
	@Column(name="Title")
	private String pubTitle;
	
	@OneToOne
	@JoinColumn(name="categoryId")
	private Category category;
	
	@Column(name="content")
	private String pubContent;

	public Integer getPubId() {
		return pubId;
	}

	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}

	public String getPubTitle() {
		return pubTitle;
	}

	public void setPubTitle(String pubTitle) {
		this.pubTitle = pubTitle;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getPubContent() {
		return pubContent;
	}

	public void setPubContent(String pubContent) {
		this.pubContent = pubContent;
	}
	
	

}
