package com.chanseok.mongodb.repository;

import com.chanseok.mongodb.document.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
}
