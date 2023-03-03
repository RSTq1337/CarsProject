package com.parsem.parse.service.serivce

import com.google.gson.Gson
import com.parsem.parse.service.dto.CarSpecsRequestQueue
import com.parsem.parse.service.serivce.api.onliner.ApiOnlinerService
import org.apache.logging.log4j.LogManager
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
@EnableRabbit
class ConsumeMessageServiceImpl(
    private var apiOnlinerService: ApiOnlinerService,
    private var onlinerApiTransferService: OnlinerApiTransferService
): ConsumeMessageService {

    @RabbitListener(queues = ["carQueue"])
    override fun consumeMessage(messageBody: String) {
        log.info("Consumed Message: $messageBody")
        var k = Gson().fromJson(messageBody, CarSpecsRequestQueue::class.java)
        var v = apiOnlinerService.getCarsByBrand(k.brands.first())
        val cars = onlinerApiTransferService.transform(v)
        log.info("//////////////////////////////")
    }
    private companion object {
        val log: org.apache.logging.log4j.Logger = LogManager.getLogger()
    }
}