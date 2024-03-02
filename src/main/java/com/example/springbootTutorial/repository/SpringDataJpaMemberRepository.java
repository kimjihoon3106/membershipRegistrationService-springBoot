package com.example.springbootTutorial.repository;

import com.example.springbootTutorial.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository{

    //SpringDtaJpaMemberRepository는
    // "select m Member as m where m.nae = name" 이라는 쿼리 구문을
    ////findByName을 override 함으로서 생략하세 해준다

    @Override
    Optional<Member> findByName(String name);
}
