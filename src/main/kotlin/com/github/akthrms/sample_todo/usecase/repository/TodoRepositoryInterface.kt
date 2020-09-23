package com.github.akthrms.sample_todo.usecase.repository

import arrow.core.Option
import com.github.akthrms.sample_todo.domain.model.Todo

interface TodoRepositoryInterface {
    fun createTodo(todo: Todo): Todo

    fun getTodo(id: Long): Option<Todo>

    fun getTodos(): List<Todo>

    fun updateTodo(todo: Todo): Todo

    fun deleteTodo(todo: Todo): Todo
}
