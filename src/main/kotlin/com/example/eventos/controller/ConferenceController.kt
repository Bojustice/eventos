package com.example.eventos.controller

import com.example.eventos.model.Conference
import com.example.eventos.model.Event
import com.example.eventos.service.ConferenceService
import com.example.eventos.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/conference")
class ConferenceController {
    @Autowired
    lateinit var conferenceService: ConferenceService

    @GetMapping
    fun list():List<Conference>{
        return conferenceService.list()
    }

    @PostMapping
    fun save(@RequestBody @Valid conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity (conferenceService.save(conference), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.update(conference), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody conference: Conference): ResponseEntity<Conference> {
        return ResponseEntity(conferenceService.updateName(conference), HttpStatus.OK)
    }

    @GetMapping
    fun list (conference: Conference, pageable: Pageable): ResponseEntity<*> {
        val response= conferenceService.list(pageable, conference)
        return ResponseEntity(response, HttpStatus.OK)
    }
}