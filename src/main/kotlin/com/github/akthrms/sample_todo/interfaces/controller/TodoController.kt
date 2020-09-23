package com.github.akthrms.sample_todo.interfaces.controller

import com.github.akthrms.sample_todo.domain.model.Todo
import com.github.akthrms.sample_todo.usecase.interactor.CreateTodoInputPortInterface
import com.github.akthrms.sample_todo.usecase.interactor.DeleteTodoInputPortInterface
import com.github.akthrms.sample_todo.usecase.interactor.GetTodosInputPortInterface
import com.github.akthrms.sample_todo.usecase.interactor.UpdateTodoInputPortInterface
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
data class TodoController(
    @Autowired
    val createTodoUsecase: CreateTodoInputPortInterface,

    @Autowired
    val getTodosUsecase: GetTodosInputPortInterface,

    @Autowired
    val updateTodoUsecase: UpdateTodoInputPortInterface,

    @Autowired
    val deleteTodoUsecase: DeleteTodoInputPortInterface
) {
    @PostMapping("/create")
    fun createTodo(@RequestBody todo: Todo): String {
        return createTodoUsecase.interact(todo)
    }

    @GetMapping("/")
    fun getTodos(): String {
        return getTodosUsecase.interact()
    }

    @PutMapping("/update")
    fun updateTodo(@RequestBody todo: Todo): String {
        return updateTodoUsecase.interact(todo)
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): String {
        return deleteTodoUsecase.interact(id)
    }
}
