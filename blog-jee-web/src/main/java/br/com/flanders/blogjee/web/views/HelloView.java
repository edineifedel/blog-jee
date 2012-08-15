package br.com.flanders.blogjee.web.views;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import br.com.flanders.blogjee.ejb.HelloService;

@ManagedBean
@RequestScoped
public class HelloView {

	@EJB
	HelloService helloService;

	public String getHelloMessage() {
		return helloService.hello("blah");
	}
}
