package com.example.url_shortener.api.controller.url.request;

import com.example.url_shortener.domain.url.OriginalUrl;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.validation.Valid;
import lombok.Data;

@Data
public class OriginalUrlRequestForm {
    @JsonUnwrapped
    @Valid
    private UrlStringForm urlStringForm;

    public OriginalUrl toDomain() {
        return new OriginalUrl(urlStringForm.toDomain());
    }
}
