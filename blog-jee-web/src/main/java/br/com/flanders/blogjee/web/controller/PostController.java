package br.com.flanders.blogjee.web.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.flanders.blogjee.entities.Post;

@ManagedBean
@RequestScoped
public class PostController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static List<Post> posts = Arrays.asList(new Post[] { new Post("Meu primeiro post", "blahblah"),
			new Post("Meu segundo post", "blehbleh") });

	public List<Post> getPosts() {
		return posts;
	}
}