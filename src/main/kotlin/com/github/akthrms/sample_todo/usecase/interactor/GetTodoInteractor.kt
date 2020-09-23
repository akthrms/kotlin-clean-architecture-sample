package com.github.akthrms.sample_todo.usecase.interactor

import com.github.akthrms.sample_todo.usecase.repository.TodoRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
data class GetTodoInteractor(
    @Autowired
    val todoRepository: TodoRepositoryInterface
) {}
