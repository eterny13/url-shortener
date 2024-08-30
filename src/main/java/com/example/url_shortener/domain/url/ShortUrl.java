package com.example.url_shortener.domain.url;

import com.example.url_shortener.domain.url.urlString.HashedUrlString;
import lombok.Value;

@Value
public class ShortUrl {
    HashedUrlString hashedUrlString;
}
