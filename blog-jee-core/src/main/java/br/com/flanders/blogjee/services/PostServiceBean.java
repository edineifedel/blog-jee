package br.com.flanders.blogjee.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.flanders.blogjee.entities.Post;

@Stateless
public class PostServiceBean implements PostService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Post save(Post post) {
		return em.merge(post);
	}

	@Override
	public void remove(Post post) {
		post = em.merge(post);
		em.remove(post);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Post> findAll() {
		return em.createQuery("select p from Post p").getResultList();
	}
}
