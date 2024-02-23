package com.example.springbootTutorial.controller;

import com.example.springbootTutorial.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.springbootTutorial.service.MemberService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {
    private final MemberService memberService;

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

    @GetMapping("membeer/$(id)")
    public String OnememberById(Model model, @RequestParam Long id){
        Optional<Member> member = memberService.findOnemember(id);
        model.addAttribute("member",member);
        return "member/byId";
    }
    @GetMapping("member")
    public String oneMemberByName(Model model,@RequestParam String name){
        return "member/byName";
    }

}
