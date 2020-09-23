package com.github.akthrms.sample_todo.usecase.interactor

import arrow.core.Option
import arrow.core.extensions.fx
import com.github.akthrms.sample_todo.domain.model.Todo
import com.github.akthrms.sample_todo.usecase.repository.TodoRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.LocalDateTime

interface UpdateTodoInputPortInterface {
    fun interact(todo: Todo): String
}

interface UpdateTodoOutputPortInterface {
    fun present(maybeId: Option<Long>): String
}

@Component
data class UpdateTodoInteractor(
    @Autowired
    val todoRepository: TodoRepositoryInterface,

    @Autowired
    val updateTodoPresenter: UpdateTodoOutputPortInterface
) : UpdateTodoInputPortInterface {
    override fun interact(todo: Todo): String {
        val result = Option.fx {
            val targetTodo = todoRepository.getTodo(todo.id!!).bind()
            val updatedTodo = todoRepository.updateTodo(
                targetTodo.copy(content = todo.content, updated = LocalDateTime.now())
            )
            updatedTodo.id!!
        }
        return updateTodoPresenter.present(result)
    }
}
