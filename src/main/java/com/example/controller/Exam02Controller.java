package com.example.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
    private final HttpSession session;

    public Exam02Controller(HttpSession session) {
        this.session = session;
    }

    @GetMapping("")
    public String index() {
        return "exam02";
    }

    @PostMapping("result")
    public String result(int num1, int num2) {
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);
        session.setAttribute("addResult", num1 + num2);
        return "exam02-result";
    }

    @GetMapping("result2")
    public String result2() {
        return "exam02-result2";
    }
}
