package com.example.eventos.model

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
@Table(name="member")
class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    @NotBlank(message="Obligatorio")
    var fullname: String? = null
    @NotBlank(message="Obligatorio")
    @Email(message="Formato incorrecto")
    var email: String? = null
    @NotBlank(message="Obligatorio")
    var age: Int? = null
}