package com.github.akthrms.sample_todo.interfaces.controller

import com.github.akthrms.sample_todo.interfaces.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
data class TodoController(
    @Autowired
    val todoRepository: TodoRepository
) {}
