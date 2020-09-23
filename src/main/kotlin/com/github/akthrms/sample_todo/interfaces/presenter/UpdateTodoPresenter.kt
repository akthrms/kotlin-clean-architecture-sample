package com.github.akthrms.sample_todo.interfaces.presenter

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import com.github.akthrms.sample_todo.usecase.interactor.UpdateTodoOutputPortInterface
import org.springframework.stereotype.Component

@Component
class UpdateTodoPresenter : UpdateTodoOutputPortInterface {
    override fun present(maybeId: Option<Long>): String {
        return when (maybeId) {
            is Some -> "id: ${maybeId.t} is updated."
            is None -> "Err: no exists todo."
        }
    }
}
