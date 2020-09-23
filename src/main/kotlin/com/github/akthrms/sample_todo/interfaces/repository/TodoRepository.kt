package com.github.akthrms.sample_todo.interfaces.repository

import com.github.akthrms.sample_todo.domain.model.Todo
import com.github.akthrms.sample_todo.usecase.repository.TodoRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface TodoJpaRepositoryInterface : JpaRepository<Todo, Long>

@Repository
data class TodoRepository(
    @Autowired
    val repository: TodoJpaRepositoryInterface
) : TodoRepositoryInterface {
    override fun createTodo(todo: Todo): Todo {
        return repository.save(todo)
    }

    override fun getTodo(): List<Todo> {
        return repository.findAll()
    }

    override fun updateTodo(todo: Todo): Todo {
        return repository.save(todo)
    }

    override fun deleteTodo(todo: Todo) {
        return repository.delete(todo)
    }
}
