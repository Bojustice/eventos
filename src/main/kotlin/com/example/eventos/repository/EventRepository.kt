package com.example.eventos.repository
import com.example.eventos.model.Event
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository: JpaRepository<Event, Long> {
    fun findById(id: Long?): Event?
}