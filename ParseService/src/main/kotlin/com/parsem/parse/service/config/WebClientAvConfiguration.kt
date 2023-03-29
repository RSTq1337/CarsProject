package com.parsem.parse.service.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientAvConfiguration {

    private val BASE_SIZE = 16 * 1024 * 1024;
    private val BASE_URL = "https://api.av.by/"

    @Bean
    fun avWebClient(webClientBuilder: WebClient.Builder): WebClient? {
        val strategies: ExchangeStrategies = ExchangeStrategies.builder()
            .codecs { codecs -> codecs.defaultCodecs().maxInMemorySize(BASE_SIZE) }
            .build()
        return webClientBuilder
            .exchangeStrategies(strategies)
            .baseUrl(BASE_URL)
            .build()
    }
}