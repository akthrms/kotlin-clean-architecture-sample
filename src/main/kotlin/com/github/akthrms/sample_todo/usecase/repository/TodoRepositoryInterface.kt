package com.github.akthrms.sample_todo.usecase.repository

import com.github.akthrms.sample_todo.domain.model.Todo

interface TodoRepositoryInterface {
    fun createTodo(todo: Todo): Todo

    fun getTodo(): List<Todo>

    fun updateTodo(todo: Todo): Todo

    fun deleteTodo(todo: Todo)
}
