package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LogTestController {
	//private final Logger log = LoggerFactory.getLogger(getClass());


	@RequestMapping("/log-test")
	public String LogTest(){
		String name="Spring";

		log.info(" info log = {}", name);

		return "ok";
	}
}
