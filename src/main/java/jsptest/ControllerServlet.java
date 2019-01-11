package jsptest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

@WebServlet("/hello")
public class ControllerServlet extends HttpServlet {
	HttpServletRequest request;
	String ip;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String greeting = (String) session.getAttribute("greeting");
		String ip = (String) session.getAttribute("ip");
		
		if(StringUtils.isBlank(ip)) {
			ip = "localhost";
		}
		
		session.setAttribute("ip", myIP());

		if (StringUtils.isBlank(greeting)) {
			greeting = "Stranger";
		}

		session.setAttribute("greeting", greeting);
	

		req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String greeting = req.getParameter("name");

		if (StringUtils.isNotBlank(greeting)) {
			req.setAttribute("greeting", greeting);
		}
		doGet(req, resp);

	}

	public String myIP() throws UnknownHostException {
		InetAddress inetAddress;
		inetAddress = InetAddress.getLocalHost();
		String ip1 = "IP Address:- " + inetAddress.getHostAddress() + "\n<br/>Host Name:- " + inetAddress.getHostName();
		return ip1;
	}
	

	public void randomString() {
		byte[] array = new byte[7]; // length is bounded by 7
		new Random().nextBytes(array);
		String generatedString = new String(array, Charset.forName("UTF-8"));

		System.out.println(generatedString);
	}
}
