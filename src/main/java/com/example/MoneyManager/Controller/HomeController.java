package com.example.MoneyManager.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({})
public class HomeController {
    @GetMapping("/health")
    public String HealthCheck()
    {
        return "API is working fine";
    }
}
