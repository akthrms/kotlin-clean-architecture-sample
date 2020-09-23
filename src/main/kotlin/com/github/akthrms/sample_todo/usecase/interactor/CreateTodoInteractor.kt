package com.github.akthrms.sample_todo.usecase.interactor

import com.github.akthrms.sample_todo.domain.model.Todo
import com.github.akthrms.sample_todo.usecase.repository.TodoRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

interface CreateTodoInputPortInterface {
    fun interact(todo: Todo): String
}

interface CreateTodoOutputPortInterface {
    fun present(id: Long): String
}

@Component
data class CreateTodoInteractor(
    @Autowired
    val todoRepository: TodoRepositoryInterface,
    @Autowired
    val createTodoPresenter: CreateTodoOutputPortInterface
) : CreateTodoInputPortInterface {
    override fun interact(todo: Todo): String {
        val newTodo = todoRepository.createTodo(todo)
        return createTodoPresenter.present(newTodo.id!!)
    }
}
