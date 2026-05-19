package com.example.controller;

import com.example.repository.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
    private final MemberRepository memberRepository;

    public Exam05Controller(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("")
    public String index() {
        return "exam05";
    }

    @PostMapping("/result")
    public String result(String name, Model model) {
        model.addAttribute("memberList", memberRepository.findByName(name));
        return "exam05-result";
    }
}
