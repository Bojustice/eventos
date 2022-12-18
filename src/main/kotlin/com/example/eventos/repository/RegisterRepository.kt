package com.example.eventos.repository
import com.example.eventos.model.Register
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RegisterRepository: JpaRepository<Register, Long> {
    fun findById(id: Long?): Register?
}