package br.com.flanders.blogjee.web.controller;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.flanders.blogjee.entities.Comment;
import br.com.flanders.blogjee.entities.Post;
import br.com.flanders.blogjee.services.PostService;

@Named
@RequestScoped
public class PostController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private PostService postService;
	private Post post = new Post();
	private Comment comment = new Comment();
	private static List<Post> posts;

	public List<Post> getPosts() {
		posts = postService.findAll();
		return posts;
	}

	public String showPost() {
		return "show";
	}

	public String listPosts() {
		return "list";
	}

	public String newPost() {
		return null;
	}

	public String updatePost() {
		return null;
	}

	public void addComment() {
		post.addComment(comment);
		postService.save(post);
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
}