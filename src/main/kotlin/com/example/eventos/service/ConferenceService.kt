package com.example.eventos.service

import com.example.eventos.model.Conference
import com.example.eventos.model.Member
import com.example.eventos.repository.ConferenceRepository
import com.example.eventos.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ConferenceService {
    @Autowired
    lateinit var conferenceRepository: ConferenceRepository

    fun list(): List<Conference> {
        return conferenceRepository.findAll()
    }

    fun save(conference: Conference): Conference {
        return conferenceRepository.save(conference)
    }

    fun update(conference: Conference): Conference {
        try{
            conferenceRepository.findById(conference.id)
                ?:throw Exception("El id ${conference.id} en event no existe")
            return conferenceRepository.save(conference)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun updateName(conference: Conference): Conference {
        try{
            val response = conferenceRepository.findById(conference.id)
                ?: throw Exception("El id no existe")
            response.apply {
                title = conference.title
            }
            return conferenceRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, conference: Conference): Page<Conference> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return conferenceRepository.findAll(Example.of(conference, matcher), pageable)
    }
}