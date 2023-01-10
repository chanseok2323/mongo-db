package com.chanseok.mongodb.document;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "member")
public class Member {

    @Id
    private String id;
    private String username;
    private String email;
    private String password;
    private Integer age;

    private Member() {
    }

    public Member(String username, String email, String password, Integer age) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
    }
}
