package com.data.jpa.controller;

import com.data.jpa.model.User;
import com.data.jpa.repository.UserRepository;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("user")
@EnableDiscoveryClient
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

    @GetMapping("/health-check")
    public @ResponseBody ResponseEntity<String> customHealthChecker() {
        String message = "health-check called at " + new Date(System.currentTimeMillis());
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
