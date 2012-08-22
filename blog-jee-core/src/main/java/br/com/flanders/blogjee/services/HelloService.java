package br.com.flanders.blogjee.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.flanders.blogjee.entities.Post;
import br.com.flanders.blogjee.entities.User;

@Stateless
public class HelloService {

	@PersistenceContext
	private EntityManager em;

	public String hello(String name) {
		return "Hello my friend " + name;
	}

	public void save(Post post) {
		em.persist(post);
	}

	public List<User> findAll() {
		return em.createQuery("select u from User u").getResultList();
	}
}
