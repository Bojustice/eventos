package com.example.eventos.model
import java.sql.Date
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="event")
class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    @NotBlank(message="Obligatorio")
    var description: String? = null
    @NotBlank (message="Obligatorio")
    @Column (name="start_date")
    var startDate: Date? = null
    @NotBlank(message="Obligatorio")
    @Column (name="end_date")
    var endDate: Date? = null
    @NotBlank(message="Obligatorio")
    @Column (name="total_attendees")
    var totalAttendees: String? = null
    @NotBlank(message="Obligatorio")
    var city: String? = null

}