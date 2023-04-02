package com.jaydot2.data.redisstorage.model

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash
@JsonPropertyOrder
@Data
@NoArgsConstructor
@AllArgsConstructor
data class UserEntity(
        @Id
        val id : String,
        val firstName : String,
        val lastName : String,
        val middleName : String
)
