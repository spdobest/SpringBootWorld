package spm.spring.world.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import spm.spring.world.models.Greeting;

@RestController
public class SpringBootSecurityController {


    @GetMapping("/")
    public String home() {
        return ("<h1>welcome</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>welcome Admin</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>welcome User</h1>");
    }

    @PostMapping("/mygreeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "greetingResult";
    }

}