package com.parsem.parse.service.sandbox

import com.parsem.parse.service.dto.entity.Brand
import com.parsem.parse.service.dto.entity.Generation
import com.parsem.parse.service.dto.entity.Model
import org.apache.logging.log4j.LogManager
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient

@RestController
class TestController (
    var testRepository: TestRepository,
    var webClient: WebClient
) {

    @GetMapping("/search")
    fun egisterRequest(@RequestAttribute brand: String) {
        val brand = Brand(1,"uaz", setOf(Model(5,"a4", setOf(Generation(15,"third")))))
        testRepository.save(brand)
        logger.info("Message Successfully send to queue")
    }

    companion object {
        private val logger = LogManager.getLogger()
    }
}