package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MappingController {

	@RequestMapping("/hello-basic")
	public String helloBasic(){
		log.info("helloBasic");
		return "OK";
	}

	@RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
	public String mappingGetV1() {
		log.info("mappingGetV1");
		return "ok";
	}

	@GetMapping("mapping-get-v2")
	public String mappingGetV2(){
		log.info("mamppingGetV2");
		return "ok";
	}

	@GetMapping("/mapping/{userId}")
	public String MappingPath(@PathVariable("userId") String data){

		log.info("mappingPath userId={}",data);
		return "ok";

	}
}
