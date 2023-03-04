package com.example.sandbox.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class AvConfiguration {
    @Bean
    fun avWebClient(webClientBuilder: WebClient.Builder): WebClient? {
        var size = 16 * 1024 * 1024;
        val strategies: ExchangeStrategies = ExchangeStrategies.builder()
            .codecs { codecs -> codecs.defaultCodecs().maxInMemorySize(size) }
            .build()
        return webClientBuilder
            .exchangeStrategies(strategies)
            .baseUrl("https://api.av.by/")
            .build()
    }
}