package com.example.eventos.model
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank


@Entity
@Table(name="register")
class Register {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    @NotBlank(message="Obligatorio")
    @Column(name="member_id")
    var memberId: Int? = null
    @NotBlank(message="Obligatorio")
    @Column(name="conference_id")
    var conferenceId: Int? = null
    @NotBlank(message="Obligatorio")
    var code: Int? = null
    @NotBlank(message="Obligatorio")
    @Column(name="registered_at")
    var registeredAt: String? = null
    @NotBlank(message="Obligatorio")
    var assisted: String? =null


}