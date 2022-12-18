package com.example.eventos.service

import com.example.eventos.model.Event
import com.example.eventos.model.Register
import com.example.eventos.repository.EventRepository
import com.example.eventos.repository.RegisterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class RegisterService {
    @Autowired
    lateinit var registerRepository: RegisterRepository

    fun list(): List<Register> {
        return registerRepository.findAll()
    }

    fun save(register: Register): Register {
        return registerRepository.save(register)
    }

    fun update(register: Register): Register {
        try{
            registerRepository.findById(register.id)
                ?:throw Exception("El id ${register.id} en event no existe")
            return registerRepository.save(register)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun updateName(register: Register): Register {
        try {
            val response = registerRepository.findById(register.id)
                ?: throw Exception("El id no existe")
            response.apply {
                code = register.code
            }
            return registerRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, register: Register): Page<Register> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return registerRepository.findAll(Example.of(register, matcher), pageable)
    }
}