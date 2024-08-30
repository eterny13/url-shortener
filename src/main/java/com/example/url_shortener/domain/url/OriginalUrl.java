package com.example.url_shortener.domain.url;

import com.example.url_shortener.domain.url.urlString.UrlString;
import lombok.Value;

@Value
public class OriginalUrl {
    UrlString urlString;
}
