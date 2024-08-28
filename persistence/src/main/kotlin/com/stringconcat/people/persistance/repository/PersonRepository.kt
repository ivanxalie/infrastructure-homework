package com.stringconcat.people.persistance.repository

import com.stringconcat.people.persistance.model.PersonEntity
import java.util.*
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<PersonEntity, UUID>
