package com.example

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.UUID

@Repository
interface ExampleRepository : CrudRepository<ExampleEntity, UUID>