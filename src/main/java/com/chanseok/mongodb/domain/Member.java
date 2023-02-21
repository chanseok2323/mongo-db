package com.chanseok.mongodb.domain;

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

    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    public static class MemberBuilder {
        private String username;
        private String email;
        private String password;
        private Integer age;

        MemberBuilder() {
        }

        public MemberBuilder username(String username) {
            this.username = username;
            return this;
        }

        public MemberBuilder email(String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder password(String password) {
            this.password = password;
            return this;
        }

        public MemberBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public Member build() {
            return new Member(username, email, password, age);
        }

        public String toString() {
            return "Member.MemberBuilder(username=" + this.username + ", email=" + this.email + ", password=" + this.password + ", age=" + this.age + ")";
        }
    }
}
