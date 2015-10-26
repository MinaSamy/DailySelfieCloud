package bloodstone.dailyselfie.cloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/testcontroller")
	public String testController(){
		return "Hello Controller";
	}

}
