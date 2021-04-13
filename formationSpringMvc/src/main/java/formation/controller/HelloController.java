package formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloController {

	// @RequestMapping(value = "/hello", method = RequestMethod.GET)
	@GetMapping({ "", "/" })
	public String hello(Model model,
			@RequestParam(name = "prenom", required = false, defaultValue = "world") String prenom,
			@RequestParam(name = "id", required = false, defaultValue = "0") Integer id) {
		model.addAttribute("prenom", prenom);
		model.addAttribute("id", id);
		return "hello";
	}

	@GetMapping("/bye")
	public String bye() {
		return "redirect:/hello?prenom=olivier";
	}
}
