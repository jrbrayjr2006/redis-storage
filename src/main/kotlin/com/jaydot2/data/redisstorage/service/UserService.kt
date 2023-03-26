package com.jaydot2.data.redisstorage.service

import com.jaydot2.data.redisstorage.model.UserEntity
import com.jaydot2.data.redisstorage.repository.UserRepository
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Slf4j
@Service
class UserService(var userRepository: UserRepository) {

    private val log = LoggerFactory.getLogger(UserService::class.java)
    fun getUserById(userId: String): UserEntity {
        log.info("Call repository to get user...")
        val optionalUser = userRepository.findById(userId)
        return optionalUser.get()
    }

    fun saveDefaultUser(id: String) : UserEntity {
        log.info("create default user...")
        val user : UserEntity = UserEntity(id, "Bob", "Jones", "P")
        userRepository.save(user)
        return user
    }
}