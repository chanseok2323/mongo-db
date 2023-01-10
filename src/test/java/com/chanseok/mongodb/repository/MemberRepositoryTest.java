package com.chanseok.mongodb.repository;

import com.chanseok.mongodb.document.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void persist_mongodb() {
        Member member = new Member("chanseok", "chanseok2323@gmail.com", "1234", 30);
        memberRepository.insert(member);

        Member findMember = memberRepository.findById(member.getId()).orElseThrow();

        Assertions.assertThat(member.getEmail()).isEqualTo(findMember.getEmail());

    }
}