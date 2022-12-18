package com.example.eventos.model
import java.sql.Date
import java.sql.Time
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="conference")
class Conference {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    @NotBlank(message="Obligatorio")
    var title: String? = null
    @NotBlank(message="Obligatorio")
    var speaker: String? = null
    @NotBlank(message="Obligatorio")
    var hora: Time? = null
    @NotBlank(message="Obligatorio")
    var dia: Date? = null
    @NotBlank(message="Obligatorio")
    var totalAttendees: Int? = null
    @NotBlank(message="Obligatorio")
    var eventId: Int? = null

}