package hello.servlet.web.frontcontroller.v5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontroller.ModelView;

public interface MyHandlerAdapter {

	//파라미터로 넘어온 handler를 지원할 수 있는지 응답해줌
	boolean supports(Object handler);

	ModelView handler(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
