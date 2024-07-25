package com.example
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject

@MicronautTest
class DemoTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    lateinit var repository: ExampleRepository

    @Inject
    lateinit var timeRepository: ExampleTimeRepository

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun testOptimisticLocking() {
        val saved = repository.save(
            ExampleEntity(
                name = "Name1",
                type = "Type1",
            )
        )
        println(repository.findAll())
        repository.update(saved.copy(name = "Changed"))
        println(repository.findAll())
        Thread.sleep(1000)
        repository.update(saved.copy(type = "ChangedType"))
        println(repository.findAll())
    }

    @Test
    fun testOptimisticLockingTime() {
        val saved = timeRepository.save(
            ExampleTimeEntity(
                name = "Name1",
                type = "Type1",
            )
        )
        println(timeRepository.findAll())
        timeRepository.update(saved.copy(name = "Changed"))
        println(timeRepository.findAll())
        Thread.sleep(1000)
        timeRepository.update(saved.copy(type = "ChangedType"))
        println(timeRepository.findAll())
    }

}
