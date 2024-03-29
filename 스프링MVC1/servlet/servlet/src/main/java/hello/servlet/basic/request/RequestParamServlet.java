package hello.servlet.basic.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[전체 파라미터 조회] - start");

		request.getParameterNames().asIterator()
				.forEachRemaining(paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));

		System.out.println("[전체 파라미터 조회] - end");
		System.out.println();

		System.out.println("[단일 파라미터 조회]");
		String username = request.getParameter("username");
		String age = request.getParameter("age");

		System.out.println("username = " + username);
		System.out.println("age = " + age);

		System.out.println("[동일 이름의 복수 파라미터 조회]");
		String[] userames = request.getParameterValues("username");
		for (String name : userames) {
			System.out.println("username = " + name);
		}

		response.getWriter().write("ok");
	}
}
