package com.jaydot2.data.redisstorage.service

import com.jaydot2.data.redisstorage.model.UserEntity
import com.jaydot2.data.redisstorage.repository.UserRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Optional

class UserServiceTest {
    val mockUserRepository : UserRepository = mockk<UserRepository>()
    val userService : UserService = UserService(mockUserRepository)

    @Test
    fun whenRequestUserById_thenReturnUserEntity() {
        // Given
        val userId = "some-id"
        val user : UserEntity = UserEntity(userId, "first", "last", "middle")
        val optionalUser : Optional<UserEntity> = Optional.of(user)
        every {mockUserRepository.findById(userId)} returns optionalUser
        // When
        val result = userService.getUserById(userId);

        // Then
        verify(exactly = 1) {mockUserRepository.findById(userId)}
        assertEquals(result, optionalUser.get())
    }

    @Test
    fun givenUserDoesNotExist_whenRequestToSaveUser_thenCallRespositorySave() {
        // Given
        val userId = "some-id"
        val user : UserEntity = UserEntity(userId, "first", "last", "middle")
        every {mockUserRepository.save(any())} returns user
        // When
        val result = userService.saveDefaultUser(userId);

        // Then
        verify(exactly = 1) {mockUserRepository.save(any())}
    }
}