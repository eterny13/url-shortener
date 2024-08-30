package com.example.url_shortener.api.controller.url.request;

import com.example.url_shortener.domain.url.urlString.UrlString;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

@ToString(includeFieldNames = false)
@Data
public class UrlStringForm {
    @JsonProperty("url")
    @NotBlank(message = "URL may not be blank")
    @URL
    public String value;

    public UrlString toDomain() {
        return new UrlString(value);
    }
}
