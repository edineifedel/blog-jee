package br.com.flanders.blogjee.services;

import br.com.flanders.blogjee.entities.Role;
import br.com.flanders.blogjee.entities.User;

public interface UserService {

	void createUser(User user, Role role);
}
