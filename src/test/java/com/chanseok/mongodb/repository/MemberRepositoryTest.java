package com.chanseok.mongodb.repository;

import com.chanseok.mongodb.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void mongo_replicaSet_transaction() {
        boolean isTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
        assertThat(isTransactionActive).isTrue();
    }

    @Test
    void persist_mongodb() {
        Member member = Member.builder()
                .username("chanseok")
                .age(31)
                .password("1234")
                .build();
        memberRepository.insert(member);

        Member findMember = memberRepository.findById(member.getId()).orElseThrow();

        assertThat(member.getEmail()).isEqualTo(findMember.getEmail());
    }
}