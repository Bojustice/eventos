package com.example.eventos.service

import com.example.eventos.model.Event
import com.example.eventos.model.Member
import com.example.eventos.repository.EventRepository
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
class MemberService {
    @Autowired
    lateinit var memberRepository: MemberRepository

    fun list(): List<Member> {
        return memberRepository.findAll()
    }

    fun save(member: Member): Member {
        return memberRepository.save(member)
    }

    fun update(member: Member): Member {
        try{
            memberRepository.findById(member.id)
                ?:throw Exception("El id ${member.id} en event no existe")
            return memberRepository.save(member)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }


    fun updateName(member: Member): Member {
        try {
            val response = memberRepository.findById(member.id)
                ?: throw Exception("El id no existe")
            response.apply {
                email = member.email
            }
            return memberRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, member: Member): Page<Member> {
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return memberRepository.findAll(Example.of(member, matcher), pageable)
    }
}