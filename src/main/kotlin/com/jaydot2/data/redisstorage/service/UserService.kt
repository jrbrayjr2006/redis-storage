package com.jaydot2.data.redisstorage.service

import com.jaydot2.data.redisstorage.model.UserEntity
import com.jaydot2.data.redisstorage.repository.UserRepository
import com.jaydot2.data.redisstorage.transformer.JsonToObjectTransformer
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.util.ResourceUtils
import java.io.File

@Slf4j
@Service
class UserService(var userRepository: UserRepository, var jsonToObjectTransformer: JsonToObjectTransformer) {

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

    fun loadData() {
        val jsonFile : File = ResourceUtils.getFile("classpath:userData.json")
        val userEntity : UserEntity = jsonToObjectTransformer.createUserEntityFromJson(jsonFile)
        log.info("saving ${userEntity?.firstName} to database...")
        userRepository.save(userEntity)
    }
}