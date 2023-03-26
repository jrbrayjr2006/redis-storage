package com.jaydot2.data.redisstorage

import com.jaydot2.data.redisstorage.model.UserEntity
import com.jaydot2.data.redisstorage.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import java.util.*
import kotlin.collections.ArrayList

@SpringBootApplication
class RedisStorageApplication(val userRepository: UserRepository) : CommandLineRunner {

	override fun run(vararg args: String?) {
		val user1 = UserEntity("101", "Peter", "Parker", "P")
		val user2 = UserEntity("102", "Mary", "Jane", "P")
		val user3 = UserEntity("103", "Norman", "Osborne", "G")
//		userRepository.save(user1)
		val users : MutableList<UserEntity> = ArrayList()
		users.add(user1)
		users.add(user2)
		users.add(user3)
		userRepository.saveAll(users)
	}
}

fun main(args: Array<String>) {
	runApplication<RedisStorageApplication>(*args)

}
