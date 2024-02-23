package com.example.springbootTutorial.controller;

import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.MemberService;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("member/new")
    public String createMemberForm(){
        return "member/createMemberForm";
    }
    @PostMapping("member/new")
    public String createMember(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        System.out.println("member = " + member.getName());

        try{
            memberService.signUp(member);

        }catch(Exception e){

        }

        return "redirect:/";
    }
}
