package com.example.url_shortener.service.url;

import com.example.url_shortener.domain.url.ShortUrl;
import com.example.url_shortener.domain.url.UrlTransformation;
import io.vavr.control.Option;

public interface UrlTransformationRepository {
    void persist(UrlTransformation urlTransformation);

    Option<UrlTransformation> findByShortUrl(ShortUrl shortUrl);
}
