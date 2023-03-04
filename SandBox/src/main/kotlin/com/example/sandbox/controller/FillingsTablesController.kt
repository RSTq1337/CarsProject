package com.example.sandbox.controller

import com.example.sandbox.service.OnlinerFillingsTablesService
import com.example.sandbox.service.AvFillingsTablesService
import org.apache.logging.log4j.LogManager
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus

@Controller
class FillingsTablesController (
    private var onlinerFillingsTablesService: OnlinerFillingsTablesService,
    private var avFillingsTablesService: AvFillingsTablesService
){
    @GetMapping("/onliner")
    @ResponseStatus(code = HttpStatus.OK)
    fun onlinerFillingsTablesRequest() {

        logger.info("Start fillings tables for onliner data")
        onlinerFillingsTablesService.execute()
    }

    @GetMapping("/av")
    @ResponseStatus(code = HttpStatus.OK)
    fun avFillingsTablesRequest() {

//        logger.info("Start fillings tables for av data")
        avFillingsTablesService.getAllManufacturers()
    }

    companion object {
        private val logger = LogManager.getLogger()
    }
}