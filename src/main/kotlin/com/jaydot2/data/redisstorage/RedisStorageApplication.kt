package com.jaydot2.data.redisstorage

import com.jaydot2.data.redisstorage.model.UserEntity
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory

@SpringBootApplication
class RedisStorageApplication

fun main(args: Array<String>) {
	runApplication<RedisStorageApplication>(*args)

}

private fun initializeData() {

	val user = UserEntity("abc1", "John", "Doe", "P")

}
