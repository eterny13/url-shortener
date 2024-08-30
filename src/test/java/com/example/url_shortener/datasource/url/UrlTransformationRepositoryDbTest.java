package com.example.url_shortener.datasource.url;

import com.example.url_shortener.domain.url.FixtureUrlTransformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UrlTransformationRepositoryDbTest {
    @Autowired
    UrlTransformationRepositoryDb sut;

    @Test
    public void persist() {
        var urlTransformation = FixtureUrlTransformation.get();
        var expected = FixtureUrlTransformation.some();

        sut.persist(urlTransformation);
        var actual = sut.findByShortUrl(urlTransformation.getShortUrl());
        assertEquals(expected, actual);
    }
}
