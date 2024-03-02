package com.example.springbootTutorial.repository;

import com.example.springbootTutorial.domain.Member;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;
    @Autowired
    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public Member save(Member member) {
        System.out.println(member.getName());
        return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m form Member as m where m,name = :name",Member.class).setParameter("name",name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member as m",Member.class).getResultList();
    }
}
