package com.safecrack.proxy

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClientBuilder


@Configuration
class RestTemplateConfiguration {

    @Bean
    fun restTemplate(): RestTemplate {
        val restTemplate = RestTemplate()
        val factory = HttpComponentsClientHttpRequestFactory()
        val httpClient: HttpClient = HttpClientBuilder.create()
            .setRedirectStrategy(NoRedirectStrategy())
            .build()
        factory.httpClient = httpClient
        restTemplate.requestFactory = factory
        return restTemplate
    }
}