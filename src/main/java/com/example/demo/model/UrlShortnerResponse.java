package com.example.demo.model;

public class UrlShortnerResponse {
    private String shortUrl;

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public String toString() {
        return "UrlShortnerResponse{" +
                "shortUrl='" + shortUrl + '\'' +
                '}';
    }
}
