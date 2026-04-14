package ntu.kiet.sessionwithspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home"; // Trả về giao diện home.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Trả về giao diện login.html
    }
}