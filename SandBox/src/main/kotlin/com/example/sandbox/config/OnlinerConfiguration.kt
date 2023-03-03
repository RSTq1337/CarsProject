package com.example.sandbox.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class OnlinerConfiguration {

    @Bean
    fun myWebClient(webClientBuilder: WebClient.Builder): WebClient? {
        return webClientBuilder
            .baseUrl("https://ab.onliner.by/sdapi/ab.api/")
            .build()
    }
}