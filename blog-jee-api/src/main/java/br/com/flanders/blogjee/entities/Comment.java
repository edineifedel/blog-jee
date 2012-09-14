package br.com.flanders.blogjee.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String comment;

	public Comment() {
		super();
	}

	public Comment(String comment) {
		super();
		this.comment = comment;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Lob
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
