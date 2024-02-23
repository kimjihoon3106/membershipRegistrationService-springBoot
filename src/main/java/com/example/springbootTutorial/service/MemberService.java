package com.example.springbootTutorial.service;

import com.example.springbootTutorial.controller.MemberForm;
import com.example.springbootTutorial.repository.MemberRepository;
import com.example.springbootTutorial.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Long signUp(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName()).ifPresent(m->{throw new IllegalStateException("이미 존재하는 회원 입니다.");});
    }
    public List<Member> findALLMembers(){
       return memberRepository.findAll();
    }
    public Optional<Member> findOnemember(Long id){
        return memberRepository.findById(id);
    }
}
