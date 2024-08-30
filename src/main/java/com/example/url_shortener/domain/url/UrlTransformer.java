package com.example.url_shortener.domain.url;

import com.example.url_shortener.domain.url.urlString.HashedUrlString;
import io.vavr.control.Try;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.util.HexFormat;

@Component
public class UrlTransformer {
    public ShortUrl transformToShortUrl(OriginalUrl url) {
        var hashedUrlString = transformToHashedUrlString(url);
        return new ShortUrl(hashedUrlString);
    }

    private HashedUrlString transformToHashedUrlString(OriginalUrl url) {
        return Try.of(() -> {
                    var sha1 = MessageDigest.getInstance("SHA-1");
                    var sha1byte = sha1.digest(url.getUrlString().getValue().getBytes());
                    var hex = HexFormat.of().withLowerCase();
                    var hexString = hex.formatHex(sha1byte);
                    return new HashedUrlString(hexString);
                }
        ).get();
    }
}
