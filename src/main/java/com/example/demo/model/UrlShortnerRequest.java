package com.example.demo.model;

public class UrlShortnerRequest {
    private String longURL;

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    @Override
    public String toString() {
        return "UrlShortnerRequest{" +
                "longURL='" + longURL + '\'' +
                '}';
    }
}
