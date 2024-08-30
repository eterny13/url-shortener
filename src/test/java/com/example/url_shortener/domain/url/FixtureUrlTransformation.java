package com.example.url_shortener.domain.url;

import io.vavr.control.Option;

public class FixtureUrlTransformation {
    public static UrlTransformation get() {
        return new UrlTransformation(
                FixtureOriginalUrl.get(),
                FixtureShortUrl.get()
        );
    }

    public static Option<UrlTransformation> some() {
        return Option.some(
                new UrlTransformation(
                        FixtureOriginalUrl.get(),
                        FixtureShortUrl.get()
                )
        );
    }
}
