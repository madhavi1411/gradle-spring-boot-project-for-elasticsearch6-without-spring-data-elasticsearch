package com.valtech.application.entity;

//import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;
import java.util.List;

/**
 * Created by madhavilatha.a on 29/11/17.
 */
//@Document(indexName = "song")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Song {
	@Id
	private Long id;
	private String title;
	private List<Comment> comments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
