package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("hello")
	public String Hello(Model model){//Model : 데이터를 실어서 View로 넘기는 것
		model.addAttribute("data", "hello");
		return "hello";//화면 이름을 return
	}
}
