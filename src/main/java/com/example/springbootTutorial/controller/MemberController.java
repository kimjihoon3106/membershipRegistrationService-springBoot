package com.example.springbootTutorial.controller;

import domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("member/new")
    public String createmember(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());
        System.out.println("member ="+member.getName());
        return "redirect";
    }
}
