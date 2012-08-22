package br.com.flanders.blogjee.web.views;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import br.com.flanders.blogjee.services.HelloService;

@ManagedBean
@RequestScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	@Inject
	HelloService helloService;

	public String getHelloMessage() {
		// return "blah";
		return helloService.hello("blah");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}