package com.example.url_shortener.domain.url;

import com.example.url_shortener.domain.url.urlString.UrlString;

public class FixtureOriginalUrl {
    public static OriginalUrl get() {
        return new OriginalUrl(
                new UrlString("example.com")
        );
    }
}
