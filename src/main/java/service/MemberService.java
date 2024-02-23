package service;

import com.example.springbootTutorial.controller.MemberController;
import com.example.springbootTutorial.controller.MemberForm;
import com.example.springbootTutorial.repository.MemberRepository;
import domain.Member;

//@RequireArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Long signUp(Member member){
        validateDupplicateMember(member);
        memberRepository.save(member);
        return Member.getId();
    }

    public void validateDupplicateMember(Member member){
        memberRepository.findByname(member.getName()).ifPresent(m-> throw new IllegalStateException("이미 존재하는 회원 입니다.")
    }
}
