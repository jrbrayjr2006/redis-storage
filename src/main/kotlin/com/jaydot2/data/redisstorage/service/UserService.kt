package com.jaydot2.data.redisstorage.service

import com.jaydot2.data.redisstorage.model.UserEntity
import com.jaydot2.data.redisstorage.repository.UserRepository
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

@Slf4j
@Service
class UserService(val userRepository: UserRepository) {
    fun getUserById(userId: String): UserEntity {
        //log.info
        val optionalUser = userRepository.findById(userId)
        return optionalUser.get()
    }
}