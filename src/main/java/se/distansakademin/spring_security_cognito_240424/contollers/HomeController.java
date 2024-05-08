package se.distansakademin.spring_security_cognito_240424.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/test")
    public String getTestPage(){
        return "test";
    }

    @PostMapping("/test")
    public String postTest(){
        System.out.println("-----------------> POST TEST <---------------");
        return "redirect:/test";

    }
}
