package com.jaydot2.data.redisstorage.controller

import com.jaydot2.data.redisstorage.model.UserEntity
import com.jaydot2.data.redisstorage.service.UserService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@WebMvcTest
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
}