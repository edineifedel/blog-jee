package br.com.flanders.blogjee.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.flanders.blogjee.entities.Post;
import br.com.flanders.blogjee.services.HelloService;
import br.com.flanders.blogjee.utils.TimeProviderUtils;

/**
 * Servlet implementation class Hello
 */
@WebServlet(name = "Hello", urlPatterns = "/hello")
public class Hello extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject
	private HelloService helloService;
	@Inject
	private TimeProviderUtils timeProviderUtils;

	public Hello() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultado = helloService.hello("Ser‡ que vai dar certo?!?!");
		PrintWriter out = response.getWriter();
		Post post = new Post();
		post.setBody("fulano");
		helloService.save(post);
		out.print("<html><body>" + resultado + " em " + timeProviderUtils.getCurrentTime() + " Id: " + post.getId()
				+ "</body></html>");
	}
}
