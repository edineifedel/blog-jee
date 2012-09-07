package br.com.flanders.blogjee.web.listener;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import br.com.flanders.blogjee.entities.Comment;
import br.com.flanders.blogjee.entities.Post;
import br.com.flanders.blogjee.entities.Role;
import br.com.flanders.blogjee.entities.User;
import br.com.flanders.blogjee.services.PostService;
import br.com.flanders.blogjee.services.UserService;

@Singleton
@Startup
public class BlogDataLoader {

	@Inject
	private UserService userService;
	@Inject
	private PostService postService;

	@PostConstruct
	public void loadData() {
		createFakePosts();
		loadAdminUserRoles();
	}

	private void createFakePosts() {
		Post post1 = new Post("My First Post", "blah blah blah");
		post1.addComment(new Comment("Comment 1"));
		post1.addComment(new Comment("Comment 2"));
		Post post2 = new Post("My Second Post", "bleh bleh bleh");
		post2.addComment(new Comment("Comment 1"));
		post2.addComment(new Comment("Comment 2"));
		postService.save(post1);
		postService.save(post2);
	}

	private void loadAdminUserRoles() {
		User user = new User("admin", "admin");
		Role role = new Role("admin", "admin");
		userService.createUser(user, role);
	}
}
