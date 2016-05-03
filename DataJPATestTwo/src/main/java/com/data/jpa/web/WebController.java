package com.data.jpa.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.data.jpa.domain.Person;
import com.data.jpa.domain.PersonRepositoryInterface;

@Controller
public class WebController {
	
	@Autowired
	PersonRepositoryInterface repositoryInterface;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		model.addAttribute("person", new Person());
		System.out.println("greetingForm GET / ");
		return "form-one";
	}

	@RequestMapping(value = "/resu", method = RequestMethod.GET)
	public String resultsControllerGet(Model model) {
		System.out.println("resultsControllerGet /res ");
		model.addAttribute("result", repositoryInterface.findAll());
		return "results";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String resultsControllerPost(@ModelAttribute @Valid Person person, BindingResult bindingResult,
			Model model) {
		System.out.println("resultsControllerPost POST /form-one ");
		if (bindingResult.hasErrors()) {
			return "form-one";
		}
		model.addAttribute("person", person);
		repositoryInterface.save(person);
		return "redirect:/resu";
	}

}
