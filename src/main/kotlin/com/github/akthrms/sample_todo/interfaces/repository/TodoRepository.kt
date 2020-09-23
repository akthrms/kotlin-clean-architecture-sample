package com.github.akthrms.sample_todo.interfaces.repository

import arrow.core.Option
import com.github.akthrms.sample_todo.domain.model.Todo
import com.github.akthrms.sample_todo.usecase.repository.TodoRepositoryInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

interface TodoJpaRepositoryInterface : JpaRepository<Todo, Long> {
    @Query("select t from Todo t where t.deleted is null")
    override fun findAll(): MutableList<Todo>
}

@Repository
data class TodoRepository(
    @Autowired
    val repository: TodoJpaRepositoryInterface
) : TodoRepositoryInterface {
    override fun createTodo(todo: Todo): Todo {
        return repository.save(todo)
    }

    override fun getTodo(id: Long): Option<Todo> {
        return Option.fromNullable(repository.findById(id).orElse(null))
    }

    override fun getTodos(): List<Todo> {
        return repository.findAll()
    }

    override fun updateTodo(todo: Todo): Todo {
        return repository.save(todo)
    }

    override fun deleteTodo(todo: Todo): Todo {
        return repository.save(todo.copy(deleted = LocalDateTime.now()))
    }
}
