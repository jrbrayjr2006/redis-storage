package com.jaydot2.data.redisstorage.repository

import com.jaydot2.data.redisstorage.model.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, String> {
}