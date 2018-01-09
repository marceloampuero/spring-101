package io.people23.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	@ResponseBody
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {

		return "Hello " + name;
	}

	@GetMapping("/fromtemplate")
	public String template(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "index";
	}

}
