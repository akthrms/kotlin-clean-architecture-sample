package com.github.akthrms.sample_todo.usecase.interactor

import com.github.akthrms.sample_todo.domain.model.Todo
import com.github.akthrms.sample_todo.usecase.repository.TodoRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

interface GetTodosInputPortInterface {
    fun interact(): String
}

interface GetTodosOutputPortInterface {
    fun present(todos: List<Todo>): String
}

@Component
data class GetTodosInteractor(
    @Autowired
    val todoRepository: TodoRepositoryInterface,

    @Autowired
    val getTodosPresenter: GetTodosOutputPortInterface
) : GetTodosInputPortInterface {
    override fun interact(): String {
        return getTodosPresenter.present(todoRepository.getTodos())
    }
}
