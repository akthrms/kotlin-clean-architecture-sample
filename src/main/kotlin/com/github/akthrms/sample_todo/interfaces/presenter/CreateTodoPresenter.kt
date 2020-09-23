package com.github.akthrms.sample_todo.interfaces.presenter

import com.github.akthrms.sample_todo.domain.model.Todo
import com.github.akthrms.sample_todo.usecase.interactor.CreateTodoOutputPortInterface
import org.springframework.stereotype.Component

@Component
class CreateTodoPresenter : CreateTodoOutputPortInterface {
    override fun present(todo: Todo): String {
        return todo.toString()
    }
}
