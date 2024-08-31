package com.example.url_shortener.service.url;

import com.example.url_shortener.domain.url.FixtureOriginalUrl;
import com.example.url_shortener.domain.url.FixtureShortUrl;
import com.example.url_shortener.domain.url.UrlTransformation;
import com.example.url_shortener.domain.url.UrlTransformer;
import io.vavr.control.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UrlTransformationServiceTest {
    UrlTransformer urlTransformer = mock(UrlTransformer.class);
    UrlTransformationRepository urlTransformationRepository = mock(UrlTransformationRepository.class);
    UrlTransformationService sut = new UrlTransformationService(urlTransformer, urlTransformationRepository);

    @BeforeEach
    void initService() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void encode() {
        var originalUrl = FixtureOriginalUrl.get();
        var expected = FixtureShortUrl.get();

        sut.encode(originalUrl);
        verify(urlTransformer, times(1)).transformToShortUrl(any());
        when(urlTransformer.transformToShortUrl(any())).thenReturn(expected);
        verify(urlTransformationRepository, times(1)).persist(any());
    }

    @Test
    public void decode() {
        var originalUrl = FixtureOriginalUrl.get();
        var shortUrl = FixtureShortUrl.get();
        var urlTransformation = Option.some(new UrlTransformation(originalUrl, shortUrl));

        sut.decode(shortUrl);
        when(urlTransformationRepository.findByShortUrl(any())).thenReturn(urlTransformation);
        verify(urlTransformationRepository, times(1)).findByShortUrl(any());
    }
}
