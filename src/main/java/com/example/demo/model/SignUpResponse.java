package com.example.demo.model;

public class SignUpResponse {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SignUpResponse{" +
                "email='" + email + '\'' +
                '}';
    }
}
