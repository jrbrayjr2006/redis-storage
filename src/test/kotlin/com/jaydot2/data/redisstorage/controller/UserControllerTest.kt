package com.jaydot2.data.redisstorage.controller

import com.jaydot2.data.redisstorage.model.UserEntity
import com.jaydot2.data.redisstorage.service.UserService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension::class)
class UserControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var mockUserService: UserService

    @Test
    fun givenExistingUser_whenRequestUser_thenReturnStatus200() {
        // Given
        val id = "some-id"
        val user = UserEntity(id, "first", "last", "middle")
        every { mockUserService.getUserById(id) } returns user

        // When...Then
        mockMvc.perform(get("/user/{id}", id))
                .andExpect(status().isOk)
    }

    @Test
    fun givenUserDoesNotExist_whenRequestToCreateUser_andSuccess_thenReturn202() {
        // Given
        val id = "some-id"
        val user = UserEntity(id, "first", "last", "middle")
        every { mockUserService.saveDefaultUser(id) } returns user

        // When...Then
        mockMvc.perform(get("/user/save/{id}", id))
                .andExpect(status().isAccepted)

    }

    @Test
    fun givenUsersDoNotExist_whenRequestLoadAll_thenReturnSuccess() {
        // Given
        every { mockUserService.loadAllData() } returns Unit
        // When...Then
        mockMvc.perform(get("/user/load/loadAll")).andExpect(status().isOk)
    }
}