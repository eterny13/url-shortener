package com.example.url_shortener.domain.url;

import com.example.url_shortener.domain.url.urlString.HashedUrlString;

public class FixtureShortUrl {
    public static ShortUrl get() {
        return new ShortUrl(
                new HashedUrlString("0caaf24ab1a0c33440c06afe99df986365b0781f")
        );
    }
}