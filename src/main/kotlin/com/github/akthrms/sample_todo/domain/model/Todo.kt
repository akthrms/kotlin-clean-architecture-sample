package com.github.akthrms.sample_todo.domain.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
@Table(name = "todos")
data class Todo(
    @Column(name = "content")
    val content: String,

    @Column(name = "created")
    val created: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated")
    val updated: LocalDateTime = LocalDateTime.now(),

    @Column(name = "deleted")
    val deleted: LocalDateTime? = null,

    @Column(name = "id")
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
