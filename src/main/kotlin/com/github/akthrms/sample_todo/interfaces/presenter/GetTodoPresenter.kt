package com.github.akthrms.sample_todo.interfaces.presenter

import com.github.akthrms.sample_todo.domain.model.Todo
import com.github.akthrms.sample_todo.usecase.interactor.GetTodoOutputPortInterface
import org.springframework.stereotype.Component

@Component
class GetTodoPresenter : GetTodoOutputPortInterface {
    override fun present(todos: List<Todo>): String {
        return if (todos.isEmpty()) {
            "todos is empty."
        } else {
            "exists ${todos.size} todos.\n${todos.joinToString("\n")}"
        }
    }
}
