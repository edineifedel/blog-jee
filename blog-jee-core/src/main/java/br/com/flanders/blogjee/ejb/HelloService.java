package br.com.flanders.blogjee.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloService {

	public String hello(String name) {
		return "Hello my friend " + name;
	}
}
