package com.github.akthrms.sample_todo.usecase.interactor

import arrow.core.Option
import arrow.core.extensions.fx
import com.github.akthrms.sample_todo.usecase.repository.TodoRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

interface DeleteTodoInputPortInterface {
    fun interact(id: Long): String
}

interface DeleteTodoOutputPortInterface {
    fun present(maybeId: Option<Long>): String
}

@Component
data class DeleteTodoInteractor(
    @Autowired
    val todoRepository: TodoRepositoryInterface,

    @Autowired
    val deleteTodoPresenter: DeleteTodoOutputPortInterface
) : DeleteTodoInputPortInterface {
    override fun interact(id: Long): String {
        val maybeId = Option.fx {
            val todo = todoRepository.getTodo(id).bind()
            val deletedTodo = todoRepository.deleteTodo(todo)
            deletedTodo.id!!
        }
        return deleteTodoPresenter.present(maybeId)
    }
}
