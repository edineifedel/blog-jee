package br.com.flanders.blogjee.web.listener;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.flanders.blogjee.entities.Role;
import br.com.flanders.blogjee.entities.User;

@Singleton
@Startup
public class BlogDataLoader {

	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	public void loadAdminUserRoles() {
		User user = new User("admin", "admin");
		Role role = new Role("admin", "admin");
		em.persist(user);
		em.persist(role);
	}
}
