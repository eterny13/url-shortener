package com.example.url_shortener.service.url;

import com.example.url_shortener.domain.url.OriginalUrl;
import com.example.url_shortener.domain.url.ShortUrl;
import com.example.url_shortener.domain.url.UrlTransformation;
import com.example.url_shortener.domain.url.UrlTransformer;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlTransformationService {
    private final UrlTransformer urlTransformer;
    private final UrlTransformationRepository repository;

    public Option<UrlTransformation> decode(ShortUrl shortUrl) {
        return repository.findByShortUrl(shortUrl);
    }

    public ShortUrl encode(OriginalUrl url) {
        var shortUrl = urlTransformer.transformToShortUrl(url);
        var urlTransformation = new UrlTransformation(url, shortUrl);
        repository.persist(urlTransformation);
        return shortUrl;
    }
}
