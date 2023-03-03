package com.parsem.webprovider.controller

import com.parsem.webprovider.dto.api.CarSpecsRequest
import com.parsem.webprovider.service.CarSpecsService
import org.apache.logging.log4j.LogManager
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/specs"])
class CarSpecsController(private val carSpecsService: CarSpecsService,
    ) {

    @PostMapping("/car-request")
    @ResponseStatus(code = HttpStatus.OK)
    fun registerRequest(@RequestBody carSpecsRequest: CarSpecsRequest) {
        logger.info("Sending message to register carSpecs request")
        carSpecsService.sendMessage(carSpecsRequest)
        logger.info("Message Successfully send to queue")
    }

    companion object {
        private val logger = LogManager.getLogger()
    }
}