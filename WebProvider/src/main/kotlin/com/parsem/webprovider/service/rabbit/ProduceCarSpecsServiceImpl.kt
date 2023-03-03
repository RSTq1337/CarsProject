package com.parsem.webprovider.service.rabbit

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.core.Binding
import org.springframework.stereotype.Service

@Service
class ProduceCarSpecsServiceImpl(
    private val rabbitTemplate: AmqpTemplate,
    private val binding: Binding
): ProduceCarSpecsService {

    override fun produceMessage(message: String): String? {
        rabbitTemplate.convertAndSend(
            binding.exchange, binding.routingKey,
            message
        )
        return "Message($message) has been produced."
    }
}