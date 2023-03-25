package com.jaydot2.data.redisstorage.controller

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

    @BeforeEach
    fun setUp() {}

    @Test
    fun givenExistingUser_whenRequestUser_thenReturnStatus200() {
        // Given
        val id = "some-id"

        // When...Then
        mockMvc.perform(get("/user/{id}", id))
                .andExpect(status().isOk)
    }
}