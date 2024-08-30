package com.example.url_shortener.datasource.url;

import com.example.url_shortener.domain.url.ShortUrl;
import com.example.url_shortener.domain.url.UrlTransformation;
import com.example.url_shortener.service.url.UrlTransformationRepository;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UrlTransformationRepositoryDb implements UrlTransformationRepository {
    private final UrlTransformationTableMapper tableMapper;

    @Override
    public void persist(UrlTransformation urlTransformation) {
        tableMapper.persist(urlTransformation);
    }

    @Override
    public Option<UrlTransformation> findByShortUrl(ShortUrl shortUrl) {
        return tableMapper.findOriginalUrl(shortUrl);
    }
}
