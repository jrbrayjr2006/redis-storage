package com.jaydot2.data.redisstorage.transformer

import com.fasterxml.jackson.databind.ObjectMapper
import com.jaydot2.data.redisstorage.model.UserEntity
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.io.File

@Slf4j
@Component
class JsonToObjectTransformer(var objectMapper : ObjectMapper) {

    val log = LoggerFactory.getLogger(JsonToObjectTransformer::class.java)

    fun createUserEntityFromJson(jsonFile: File) : UserEntity {
        log.info("map JSON file to UserEntity...")
        val userEntity : UserEntity = objectMapper.readValue(jsonFile, UserEntity::class.java)
        log.info("The first name is ${userEntity?.firstName}")
        return userEntity
    }
}