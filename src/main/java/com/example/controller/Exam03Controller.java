package com.example.controller;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
    private final ServletContext application;

    public Exam03Controller(ServletContext application) {
        this.application = application;
    }

    @GetMapping("")
    public String index() {
        return "exam03";
    }

    @PostMapping("result")
    public String result(int num1, int num2, int num3) {
        int sum = num1 + num2 + num3;
        int sumIncludeTax = (int) (sum * 1.1);
        application.setAttribute("sum", sum);
        application.setAttribute("sumIncludeTax", sumIncludeTax);
        return "exam03-result";
    }
}
