package com.example.eventos.repository
import com.example.eventos.model.Conference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ConferenceRepository: JpaRepository<Conference, Long> {
    fun findById(id: Long?): Conference?
}