package com.valtech.application.entity;

import javax.persistence.Id;

/**
 * Created by madhavilatha.a on 29/11/17.
 */
public class Comment {
	@Id
	private Long id;
	private String commentStr;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentStr() {
		return commentStr;
	}

	public void setCommentStr(String commentStr) {
		this.commentStr = commentStr;
	}
}
