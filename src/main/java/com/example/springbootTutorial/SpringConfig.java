package com.example.springbootTutorial;

import com.example.springbootTutorial.repository.JpaMemberRepository;
import com.example.springbootTutorial.repository.MemberRepository;
import com.example.springbootTutorial.repository.SpringDataJpaMemberRepository;
import com.example.springbootTutorial.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    //private final EntityManager em;
    private final SpringDataJpaMemberRepository springDataJpaMemberRepository;
    @Autowired
    public SpringConfig(SpringDataJpaMemberRepository springDataJpaMemberRepository){
        //this.em=em;
        this.springDataJpaMemberRepository = springDataJpaMemberRepository;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(springDataJpaMemberRepository);
    }
//    @Bean
//    public MemberRepository memberRepository(){
//        return new JpaMemberRepository(em);
//    }



}
