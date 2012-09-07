package br.com.flanders.blogjee.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.flanders.blogjee.entities.Role;
import br.com.flanders.blogjee.entities.User;

@Stateless
public class UserServiceBean implements UserService {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void createUser(User user, Role role) {
		em.persist(user);
		em.persist(role);
	}
}
