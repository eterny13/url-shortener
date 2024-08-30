package com.example.url_shortener.domain.url;

import lombok.Value;

@Value
public class UrlTransformation {
    OriginalUrl originalUrl;
    ShortUrl shortUrl;
}
