package com.parsem.webprovider.service.rabbit

interface ProduceCarSpecsService {
    fun produceMessage(message: String): String?
}