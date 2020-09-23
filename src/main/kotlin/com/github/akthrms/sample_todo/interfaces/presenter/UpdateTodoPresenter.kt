package com.github.akthrms.sample_todo.interfaces.presenter

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import com.github.akthrms.sample_todo.domain.model.Todo
import com.github.akthrms.sample_todo.usecase.interactor.UpdateTodoOutputPortInterface
import org.springframework.stereotype.Component

@Component
class UpdateTodoPresenter : UpdateTodoOutputPortInterface {
    override fun present(maybeTodo: Option<Todo>): String {
        return when (maybeTodo) {
            is Some -> "id: ${maybeTodo.t.id} is updated."
            is None -> "Err: no exists todo."
        }
    }
}
