package com.example.demo.controller;

import com.example.demo.model.SignUpRequest;
import com.example.demo.model.SignUpResponse;
import com.example.demo.model.UrlShortnerRequest;
import com.example.demo.model.UrlShortnerResponse;
import com.example.demo.service.SignUpService;
import com.example.demo.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UrlShortnerController {

    @Autowired
    UrlShortnerService urlShortnerService;

    @Autowired
    SignUpService signUpService;
    @PostMapping(value="/shorten")
    public UrlShortnerResponse shortenURL(@RequestBody UrlShortnerRequest urlShortnerRequest){
        //  System.out.println(urlShortnerRequest.toString());
       // UrlShortnerResponse sURL = new UrlShortnerResponse();
        //sURL.setShortUrl("www.jghdjsf.com");
       // return sURL;
        UrlShortnerResponse result= urlShortnerService.getSURLFromDB(urlShortnerRequest.getLongURL());
        return result;

    }
    @GetMapping(value="/long-url")
    public UrlShortnerRequest getLongUURLRes(@RequestParam(name = "short") String shorted){
        UrlShortnerRequest resultLong = urlShortnerService.getLongURLService(shorted);
        return resultLong;
    }

    @PostMapping(value="/signUp")
    public SignUpResponse signUpUser(@RequestBody SignUpRequest signUpRequest){
        SignUpResponse resultSignUp = signUpService.saveUser(signUpRequest);
        return resultSignUp;
    }

}
