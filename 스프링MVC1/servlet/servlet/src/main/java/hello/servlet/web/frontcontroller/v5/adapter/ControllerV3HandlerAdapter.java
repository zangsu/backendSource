package hello.servlet.web.frontcontroller.v5.adapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof ControllerV3);
		//넘어온 객체가 ControllerV3를 구현한 클래스인지...

	}

	@Override
	public ModelView handler(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

		ControllerV3 controller = (ControllerV3)handler;
		//ControllerV3임을 보장할 수 있기 때문에 캐스팅이 가능하다.

		Map<String, String> paramMap = createParamMap(request);
		ModelView mv = controller.process(paramMap);

		return mv;
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator()
			.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		return paramMap;
	}

}
