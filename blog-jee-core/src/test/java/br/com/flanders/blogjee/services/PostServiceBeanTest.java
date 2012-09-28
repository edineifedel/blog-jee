package br.com.flanders.blogjee.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import br.com.flanders.blogjee.entities.Comment;
import br.com.flanders.blogjee.entities.Post;

public class PostServiceBeanTest {

	private EJBContainer container;
	@Inject
	private PostService postService;

	@Before
	public void setUp() throws Exception {
		startContainer();
		createSomePosts();
	}

	private void startContainer() throws NamingException {
		container = EJBContainer.createEJBContainer();
		container.getContext().bind("inject", this);
	}

	private void createSomePosts() {
		Post post1 = createPost("Title post 1", "Body post 1", "a", "b");
		Post post2 = createPost("Title post 2", "Body post 2", "c", "d");
		postService.save(post1);
		postService.save(post2);
	}

	@Test
	public void testFindAll() {
		List<Post> posts = postService.findAll();
		assertEquals(2, posts.size());
	}

	@Test
	public void testSave() {
		Post post = createPost("Title post 3", "Body post 3", "e", "f");
		Post savedPost = postService.save(post);
		assertNotNull(savedPost);
		assertNotNull(savedPost.getId());
		assertEquals(2, savedPost.getComments().size());
		List<Post> posts = postService.findAll();
		assertEquals(3, posts.size());
	}

	@Test
	public void testRemove() {
		Post anyPost = postService.findAll().get(0);
		postService.remove(anyPost);
		List<Post> posts = postService.findAll();
		assertEquals(1, posts.size());
	}

	private Post createPost(String title, String body, String... comments) {
		Post post = new Post(title, body);
		for (String comment : comments) {
			post.addComment(new Comment(comment));
		}
		return post;
	}

	@After
	public void stop() {
		container.close();
	}
}
