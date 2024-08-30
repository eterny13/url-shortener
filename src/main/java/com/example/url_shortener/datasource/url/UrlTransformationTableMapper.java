package com.example.url_shortener.datasource.url;

import com.example.url_shortener.domain.url.OriginalUrl;
import com.example.url_shortener.domain.url.ShortUrl;
import com.example.url_shortener.domain.url.UrlTransformation;
import com.example.url_shortener.domain.url.urlString.HashedUrlString;
import com.example.url_shortener.domain.url.urlString.UrlString;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import static com.example.generated.db.Tables.URLTRANSFORMATION;


@Component
@RequiredArgsConstructor
public class UrlTransformationTableMapper {
    private final DSLContext dsl;

    public void persist(UrlTransformation urlTransformation) {
        dsl.insertInto(URLTRANSFORMATION)
                .set(URLTRANSFORMATION.ORIGINALURL, urlTransformation.getOriginalUrl().getUrlString().getValue())
                .set(URLTRANSFORMATION.SHORTURL, urlTransformation.getShortUrl().getHashedUrlString().getValue())
                .execute();
    }

    public Option<UrlTransformation> findOriginalUrl(ShortUrl shortUrl) {
        return Option.ofOptional(
                dsl.selectFrom(URLTRANSFORMATION)
                        .where(URLTRANSFORMATION.SHORTURL.eq(shortUrl.getHashedUrlString().getValue()))
                        .fetchOptional()
        ).map(raw -> new UrlTransformation(
                new OriginalUrl(new UrlString(raw.getOriginalurl())),
                new ShortUrl(new HashedUrlString(raw.getShorturl())))
        );
    }
}
