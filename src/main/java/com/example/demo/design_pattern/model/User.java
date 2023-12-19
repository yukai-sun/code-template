package com.example.demo.design_pattern.model;

import lombok.ToString;

@ToString
public class User {
    private String username;
    private String password;

    private User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public static class Builder {
        private String username;
        private String password;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}