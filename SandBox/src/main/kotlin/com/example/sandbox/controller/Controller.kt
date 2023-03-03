package com.example.sandbox.controller

import com.example.sandbox.service.FillingsTablesService
import org.apache.logging.log4j.LogManager
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus

@Controller
class Controller (
    private var fillingsTablesService: FillingsTablesService
){
    @GetMapping("/test")
    @ResponseStatus(code = HttpStatus.OK)
    fun registerRequest() {

        logger.info("Message Successfully send to queue")
        fillingsTablesService.execute()
    }

    companion object {
        private val logger = LogManager.getLogger()
    }
}