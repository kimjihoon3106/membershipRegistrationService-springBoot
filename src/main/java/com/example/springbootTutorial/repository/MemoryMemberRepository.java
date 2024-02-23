package com.example.springbootTutorial.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.example.springbootTutorial.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;

@Repository
//이클래스에서는 회원가입된 회원을 db에 저장하지 않고 javaproject 내에 일단 저장을 하는 기능을 구현한다.
public class MemoryMemberRepository implements MemberRepository{
    public static Map<Long,Member> store = new HashMap<>();

    public static Long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(sequence,member);
        return member;

    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));

    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
