package com.example

import io.micronaut.data.annotation.Version
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.Instant
import java.time.ZonedDateTime
import java.util.*

@Entity
data class ExampleTimeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    @Column
    val name: String,
    @Column
    val type: String,
    @Column
    val createdAt: Instant = ZonedDateTime.now().toInstant(),
    @Version
    @Column
    var updatedAt: Instant = ZonedDateTime.now().toInstant(),
)
