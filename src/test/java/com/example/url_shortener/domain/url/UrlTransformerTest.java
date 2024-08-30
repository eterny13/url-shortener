package com.example.url_shortener.domain.url;

import com.example.url_shortener.domain.url.urlString.HashedUrlString;
import com.example.url_shortener.domain.url.urlString.UrlString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UrlTransformerTest {
    @Autowired
    UrlTransformer urlTransformer;

    @Test
    public void transformToShortUrl() {
        UrlString urlString = new UrlString("example.com");
        OriginalUrl originalUrl = new OriginalUrl(urlString);
        ShortUrl actual = urlTransformer.transformToShortUrl(originalUrl);

        HashedUrlString hashedUrlString = new HashedUrlString("0caaf24ab1a0c33440c06afe99df986365b0781f");
        ShortUrl expected = new ShortUrl(hashedUrlString);
        assertEquals(expected, actual);
    }
}
