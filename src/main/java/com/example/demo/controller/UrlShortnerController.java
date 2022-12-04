package com.example.demo.controller;

import com.example.demo.model.UrlShortnerRequest;
import com.example.demo.model.UrlShortnerResponse;
import com.example.demo.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortnerController {

    @Autowired
    UrlShortnerService urlShortnerService;
    @PostMapping(value="/shorten")
    public UrlShortnerResponse shortenURL(@RequestBody UrlShortnerRequest urlShortnerRequest){
        //  System.out.println(urlShortnerRequest.toString());
       // UrlShortnerResponse sURL = new UrlShortnerResponse();
        //sURL.setShortUrl("www.jghdjsf.com");
       // return sURL;
        UrlShortnerResponse result= urlShortnerService.getSURLFromDB(urlShortnerRequest.getLongURL());
        return result;

    }
    @GetMapping(value="/getLongURL")
    public UrlShortnerRequest getLongUURLRes(@RequestBody UrlShortnerResponse urlShortnerResponse){
        UrlShortnerRequest resultLong = urlShortnerService.getLongURLService(urlShortnerResponse.getShortUrl());
        return resultLong;
    }

}
