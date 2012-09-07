package br.com.flanders.blogjee.web.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MyBean implements Serializable {

	private static final long serialVersionUID = 1L;
	String state = "";

	@PostConstruct
	public void test() {
		System.out.println("pc called");
		state = "state set";
	}

	public String getState() {
		return state;
	}

	public String action() {
		return "";
	}
}