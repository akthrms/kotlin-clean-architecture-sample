package com.github.akthrms.sample_todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleTodoApplication

fun main(args: Array<String>) {
	runApplication<SampleTodoApplication>(*args)
}
