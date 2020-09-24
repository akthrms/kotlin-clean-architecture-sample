package com.github.akthrms.sample_todo.interfaces.presenter

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import com.github.akthrms.sample_todo.usecase.interactor.DeleteTodoOutputPortInterface
import org.springframework.stereotype.Component

@Component
class DeleteTodoPresenter : DeleteTodoOutputPortInterface {
    override fun present(maybeId: Option<Long>): String {
        return when (maybeId) {
            is Some -> "Ok: id ${maybeId.t} is deleted."
            is None -> "Err: no exists todo."
        }
    }
}
