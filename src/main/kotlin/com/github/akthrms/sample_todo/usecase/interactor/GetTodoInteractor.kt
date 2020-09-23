package com.github.akthrms.sample_todo.usecase.interactor

import com.github.akthrms.sample_todo.domain.model.Todo
import com.github.akthrms.sample_todo.usecase.repository.TodoRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

interface GetTodoInputPortInterface {
    fun interact(): String
}

interface GetTodoOutputPortInterface {
    fun present(todos: List<Todo>): String
}

@Component
data class GetTodoInteractor(
    @Autowired
    val todoRepository: TodoRepositoryInterface,
    @Autowired
    val getTodoPresenter: GetTodoOutputPortInterface
) : GetTodoInputPortInterface {
    override fun interact(): String {
        return getTodoPresenter.present(todoRepository.getTodos())
    }
}
