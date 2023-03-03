package com.example.sandbox

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SandBoxApplication

fun main(args: Array<String>) {
	runApplication<SandBoxApplication>(*args)
}
