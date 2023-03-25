package com.jaydot2.data.redisstorage.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.convert.KeyspaceConfiguration
import org.springframework.data.redis.core.convert.MappingConfiguration
import org.springframework.data.redis.core.index.IndexConfiguration
import org.springframework.data.redis.core.mapping.RedisMappingContext
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@Configuration
@EnableRedisRepositories
class RedisConfig {

    @Bean
    fun connectionFactory() : RedisConnectionFactory {
        return LettuceConnectionFactory()
    }

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory) : RedisTemplate<String, Any> {
        val template : RedisTemplate<String, Any> = RedisTemplate()
        template.setConnectionFactory(redisConnectionFactory)
        return template
    }

    @Bean
    fun keyValueMappingContext() : RedisMappingContext? {
        return RedisMappingContext(
                MappingConfiguration(IndexConfiguration(), BaseKeyspaceConfiguration())
        )
    }

    class BaseKeyspaceConfiguration : KeyspaceConfiguration() {

        override fun initialConfiguration(): MutableIterable<KeyspaceSettings> {
            // add configuration here
            // val someSettings = KeyspaceSettings(Some::class.java, "some")
            // return listOf(someSettings)
            return super.initialConfiguration()
        }
    }
}