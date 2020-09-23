package com.github.akthrms.sample_todo.interfaces.presenter

import com.github.akthrms.sample_todo.usecase.interactor.CreateTodoOutputPortInterface
import org.springframework.stereotype.Component

@Component
class CreateTodoPresenter : CreateTodoOutputPortInterface {
    override fun present(id: Long): String {
        return "id: $id is created."
    }
}
