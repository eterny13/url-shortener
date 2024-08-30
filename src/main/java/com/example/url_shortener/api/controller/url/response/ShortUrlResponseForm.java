package com.example.url_shortener.api.controller.url.response;

import com.example.url_shortener.domain.url.ShortUrl;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShortUrlResponseForm {
    @JsonProperty("short_url")
    private final String shortUrl;

    public static ShortUrlResponseForm of(ShortUrl shortUrl) {
        return new ShortUrlResponseForm(shortUrl.getHashedUrlString().getValue());
    }
}
