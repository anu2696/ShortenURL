package com.example.demo.service;

import com.example.demo.dao.entity.SignUp;
import com.example.demo.dao.repository.UrlShortnerRepo;
import com.example.demo.model.SignUpRequest;
import com.example.demo.model.SignUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    @Autowired
    UrlShortnerRepo urlShortnerRepo;

    public SignUpResponse saveUser(SignUpRequest signUpRequest){
        SignUpResponse signUpResponse = new SignUpResponse();
        SignUp signUpEntity = new SignUp();
        signUpEntity.setEmail(signUpRequest.getEmail());
        signUpEntity.setPassword(signUpRequest.getPassword());
        urlShortnerRepo.save(signUpEntity);
        signUpResponse.setEmail(signUpRequest.getEmail());
        return signUpResponse;
    }
}
