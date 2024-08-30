package com.example.url_shortener.api.controller.url;

import com.example.url_shortener.api.controller.url.request.UrlStringForm;
import com.example.url_shortener.api.controller.url.response.OriginalUrlResponseForm;
import com.example.url_shortener.api.controller.url.response.ShortUrlResponseForm;
import com.example.url_shortener.domain.url.OriginalUrl;
import com.example.url_shortener.domain.url.ShortUrl;
import com.example.url_shortener.domain.url.urlString.HashedUrlString;
import com.example.url_shortener.service.url.UrlTransformationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UrlShortenerApi {
    private final UrlTransformationService service;

    @RequestMapping(value = "/encode", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> encode(@RequestBody @Valid UrlStringForm urlStringForm) {
        var originalUrl = new OriginalUrl(urlStringForm.toDomain());
        var shortUrl = service.encode(originalUrl);
        return ResponseEntity.status(201).body(ShortUrlResponseForm.of(shortUrl));
    }

    @RequestMapping(value = "/decode/{hashedString}", method = RequestMethod.GET)
    public ResponseEntity<?> decode(@PathVariable @Valid String hashedString) {
        var shortUrl = new ShortUrl(new HashedUrlString(hashedString));
        var urlTransformation = service.decode(shortUrl);
        return urlTransformation.fold(
                () -> ResponseEntity.status(404).body("not found"),
                x -> ResponseEntity.status(200).body(OriginalUrlResponseForm.of(x.getOriginalUrl()))
        );
    }
}
