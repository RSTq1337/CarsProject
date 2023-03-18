package com.parsem.webprovider

import com.parsem.webprovider.config.RabbitConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import


@SpringBootApplication
@Import(
    RabbitConfiguration::class)
class WebProviderApplication
    fun main(args: Array<String>) {
        runApplication<WebProviderApplication>(*args)
    }

