package com.jaydot2.data.redisstorage.model

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import org.springframework.data.redis.core.RedisHash

@RedisHash
@JsonPropertyOrder
data class UserEntity(
        val firstName : String,
        val lastName : String,
        val middleName : String
)
