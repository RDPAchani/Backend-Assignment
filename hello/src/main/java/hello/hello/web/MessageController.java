package hello.hello.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller

public class MessageController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String greetingForm(@RequestParam String name, @RequestParam int age, Model model) {
		model.addAttribute("name", name);

        model.addAttribute("age", age);
		return "result";
	}

}
