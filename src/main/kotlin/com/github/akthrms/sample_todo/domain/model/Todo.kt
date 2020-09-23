package com.github.akthrms.sample_todo.domain.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "todos")
data class Todo(
    val content: String,
    val created: LocalDateTime = LocalDateTime.now(),
    val updated: LocalDateTime = LocalDateTime.now(),
    val deleted: LocalDateTime? = null,
    @GeneratedValue
    @Id
    val id: Long? = null
) {
    override fun toString(): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:MM:SS")
        val format = { localDateTime: LocalDateTime -> localDateTime.format(formatter) }
        return "Todo(id=${id}, content=${content}, created=${format(created)}, updated=${format(updated)})"
    }
}
