package com.data.jpa.controller;

import com.data.jpa.model.User;
import com.data.jpa.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class WebController {

    final UserRepository userRepository;

    public WebController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("ping")
    public String greetingForm(Model model) {
        model.addAttribute("person", new User());
        System.out.println("greetingForm GET / ");
        return "form-one";
    }

    @GetMapping
    public String resultsControllerGet(Model model) {
        System.out.println("resultsControllerGet /res ");
        model.addAttribute("result", userRepository.findAll());
        return "results";
    }

    @PostMapping
    public String resultsControllerPost(@ModelAttribute User user, BindingResult bindingResult,
                                        Model model) {
        System.out.println("resultsControllerPost POST /form-one ");
        if (bindingResult.hasErrors()) {
            return "form-one";
        }
        model.addAttribute("user", user);
        userRepository.save(user);
        return "redirect:/user";
    }

}
