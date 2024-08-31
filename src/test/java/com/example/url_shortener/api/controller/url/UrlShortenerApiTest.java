package com.example.url_shortener.api.controller.url;

import com.example.url_shortener.domain.url.FixtureShortUrl;
import com.example.url_shortener.domain.url.FixtureUrlTransformation;
import com.example.url_shortener.domain.url.OriginalUrl;
import com.example.url_shortener.domain.url.ShortUrl;
import com.example.url_shortener.service.url.UrlTransformationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UrlShortenerApiTest {
    @MockBean
    private UrlTransformationService urlTransformationService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_encode() throws Exception {
        Mockito.when(urlTransformationService.encode(Mockito.any(OriginalUrl.class))).thenReturn(FixtureShortUrl.get());

        ResultActions resultActions = mockMvc.perform(
                post("/encode")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"url\":\"https://example.com\"}")
        );

        resultActions.andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"short_url\":\"0caaf24ab1a0c33440c06afe99df986365b0781f\"}"));
    }

    @Test
    void test_decode_success() throws Exception {
        Mockito.when(urlTransformationService.decode(Mockito.any(ShortUrl.class))).thenReturn(FixtureUrlTransformation.some());

        ResultActions resultActions = mockMvc.perform(
                get("/decode/0caaf24ab1a0c33440c06afe99df986365b0781f")
        );

        resultActions.andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"original_url\":\"example.com\"}"));
    }

    @Test
    void test_decode_not_found() throws Exception {
        Mockito.when(urlTransformationService.decode(Mockito.any(ShortUrl.class))).thenReturn(FixtureUrlTransformation.none());

        ResultActions resultActions = mockMvc.perform(
                get("/decode/0caaf24a")
        );

        resultActions.andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string("not found"));
    }
}
