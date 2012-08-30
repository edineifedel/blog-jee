package br.com.flanders.blogjee.web.controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import br.com.flanders.blogjee.entities.User;

@ManagedBean
@RequestScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() {
		FacesContext.getCurrentInstance().addMessage("pwd",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Usu‡rio/Senha incorreto", null));
		return null;
		// return "/blog/posts/list";
	}
}