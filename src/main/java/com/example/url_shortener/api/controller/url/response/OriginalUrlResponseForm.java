package com.example.url_shortener.api.controller.url.response;

import com.example.url_shortener.domain.url.OriginalUrl;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OriginalUrlResponseForm {
    @JsonProperty("original_url")
    private final String originalUrl;

    public static OriginalUrlResponseForm of(OriginalUrl originalUrl) {
        return new OriginalUrlResponseForm(originalUrl.getUrlString().getValue());
    }
}
