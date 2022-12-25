package com.example.eventos.controller
import com.example.eventos.model.Event
import com.example.eventos.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/event")
class EventController {
    @Autowired
    lateinit var eventService: EventService

    @GetMapping
    fun list (event: Event, pageable: Pageable):ResponseEntity<*>{
        val response= eventService.list(pageable, event)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid event:Event): ResponseEntity<Event> {
        return ResponseEntity (eventService.save(event), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody event:Event): ResponseEntity<Event> {
        return ResponseEntity(eventService.update(event), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody event: Event): ResponseEntity<Event> {
        return ResponseEntity(eventService.updateName(event), HttpStatus.OK)
    }



}