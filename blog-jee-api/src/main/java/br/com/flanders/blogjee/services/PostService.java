package br.com.flanders.blogjee.services;

import java.util.List;
import br.com.flanders.blogjee.entities.Post;

public interface PostService {

	Post save(Post post);

	void remove(Post post);

	List<Post> findAll();
}
