package com.example.demo.controller;

import com.example.demo.model.UrlShortnerRequest;
import com.example.demo.model.UrlShortnerResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortnerController {

    @PostMapping(value="/shorten")
    public UrlShortnerResponse shortenURL(@RequestBody UrlShortnerRequest urlShortnerRequest){
        System.out.println(urlShortnerRequest.toString());
        UrlShortnerResponse sURL = new UrlShortnerResponse();
        sURL.setShortUrl("www.jghdjsf.com");
        return sURL;
    }

}
