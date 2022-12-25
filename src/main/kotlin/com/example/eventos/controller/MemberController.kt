package com.example.eventos.controller

import com.example.eventos.model.Event
import com.example.eventos.model.Member
import com.example.eventos.service.EventService
import com.example.eventos.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/member")
class MemberController {
    @Autowired
    lateinit var memberService: MemberService

    @GetMapping
    fun list (member: Member, pageable: Pageable): ResponseEntity<*> {
        val response= memberService.list(pageable, member)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid member: Member): ResponseEntity<Member> {
        return ResponseEntity (memberService.save(member), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody member: Member): ResponseEntity<Member> {
        return ResponseEntity(memberService.update(member), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody member: Member): ResponseEntity<Member> {
        return ResponseEntity(memberService.updateName(member), HttpStatus.OK)
    }


}