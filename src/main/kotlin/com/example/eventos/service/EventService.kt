package com.example.eventos.service
import com.example.eventos.model.Event
import com.example.eventos.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class EventService {
    @Autowired
    lateinit var eventRepository: EventRepository

    fun list(): List<Event> {
        return eventRepository.findAll()
    }

    fun save(event: Event): Event {
        return eventRepository.save(event)
    }

    fun update(event: Event):Event{
        try{
            eventRepository.findById(event.id)
                ?:throw Exception("El id ${event.id} en event no existe")
            return eventRepository.save(event)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun updateName(event: Event): Event {
        try {
            val response = eventRepository.findById(event.id)
                ?: throw Exception("El id no existe")
            response.apply {
                city = event.city
            }
            return eventRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, event: Event): Page<Event> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return eventRepository.findAll(Example.of(event, matcher), pageable)
    }

}