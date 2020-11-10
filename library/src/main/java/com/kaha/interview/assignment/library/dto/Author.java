package com.kaha.interview.assignment.library.dto;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long authorId;
	private String authorTitle;
	private String authorDescription;
	private Date createdDate;
	private Date lastUpdatedDate;
	
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getAuthorTitle() {
		return authorTitle;
	}
	public void setAuthorTitle(String authorTitle) {
		this.authorTitle = authorTitle;
	}
	public String getAuthorDescription() {
		return authorDescription;
	}
	public void setAuthorDescription(String authorDescription) {
		this.authorDescription = authorDescription;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	
}
