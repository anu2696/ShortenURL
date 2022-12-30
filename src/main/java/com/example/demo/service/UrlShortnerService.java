package com.example.demo.service;

import com.example.demo.dao.entity.UrlShortener;
import com.example.demo.dao.repository.UrlShortnerRepo;
import com.example.demo.model.UrlShortnerRequest;
import com.example.demo.model.UrlShortnerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlShortnerService {

    private String startCode="00000";
    @Autowired
    UrlShortnerRepo urlShortnerRepo;

    public UrlShortnerResponse getSURLFromDB(String longUrl){
       /* UrlShortener urlShortener1 = urlShortnerRepo.findByLongUrl(longUrl);
        String longU = urlShortener1.getLongUrl();
        System.out.println(longU);*/
       /*if(longU.equals(longUrl)){
            UrlShortnerResponse resResponse= new UrlShortnerResponse();
            String shortURL = urlShortener1.getShortURL();
            resResponse.setShortUrl(shortURL);
            return resResponse;
        }*/
        //else {
            UrlShortener urlShortner = urlShortnerRepo.findTopByOrderByIdDesc();
            UrlShortnerResponse resResponse = new UrlShortnerResponse();
            if (urlShortner == null) {
                String tCode = translateCode(startCode);
                urlShortner = new UrlShortener();
                urlShortner.setLongUrl(longUrl);
                urlShortner.setCode(startCode);
                urlShortner.setShortURL(tCode);
                urlShortnerRepo.save(urlShortner);
                resResponse.setShortUrl(tCode);

            }
        /*else if(){
            urlShortner = new UrlShortener();
            urlShortner.getLongUrl();
            urlShortner.getShortURL();
            urlShortner.getCode();
            urlShortner.getId();
            resResponse.getShortUrl();
        }*/
            else {
                String newCode = urlShortner.getCode();
                int newIntCode = Integer.parseInt(newCode) + 1;
                String tCode = translateCode(String.format("%05d", newIntCode));
                urlShortner = new UrlShortener();
                urlShortner.setLongUrl(longUrl);
                urlShortner.setCode(newIntCode + "");
                urlShortner.setShortURL(tCode);
                urlShortnerRepo.save(urlShortner);
                resResponse.setShortUrl(tCode);

            }
            return resResponse;
        //}

    }

    public UrlShortnerRequest getLongURLService(String shortURL){
       // UrlShortener urlShortner= urlShortnerRepo.findTopByOrderByIdDesc();
        UrlShortener urlShortner= urlShortnerRepo.findByShortURL(shortURL);
        UrlShortnerRequest resRequest= new UrlShortnerRequest();
        String longURL = urlShortner.getLongUrl();
        resRequest.setLongURL(longURL);
        return resRequest;
    }

    private String translateCode(String code){
        Map<String, String> dict = new HashMap<>();
        dict.put("0", "a");
        dict.put("1", "b");
        dict.put("2", "c");

        dict.put("3", "d");
        dict.put("4", "e");
        dict.put("5", "f");
        dict.put("6", "g");
        dict.put("7", "h");
        dict.put("8", "i");
        dict.put("9", "j");

        char[] codeArr = code.toCharArray();
        StringBuilder res =  new StringBuilder();
        for (char c : codeArr) {
            res.append(dict.get(c + ""));
        }
        return res.toString();
    }
}
