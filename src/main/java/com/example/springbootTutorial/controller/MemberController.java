package com.example.springbootTutorial.controller;

import com.example.springbootTutorial.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.springbootTutorial.service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
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
    @GetMapping("member/all")
    public String allMembers(Model model){
        List<Member> members = memberService.findALLMembers();
        model.addAttribute("memberList",members);
        return "member/list";
    }
    @ResponseBody

    @GetMapping("member")
    public Optional<Member> OnememberById(Model model,@RequestParam(value = "id", required = false,defaultValue = "1")Long id) {
        Optional<Member> member = memberService.findOneMemberById(id);
        return member;
    }
    @ResponseBody
    @GetMapping("member/{name}")
    public Optional<Member> oneMemberByName(Model model,@PathVariable(value = "name",required = false) String name){
        Optional<Member> member = memberService.findOneMemberByName(name);
        System.out.println(member.get().getName()+member.get().getId());
        return member;
    }
}
