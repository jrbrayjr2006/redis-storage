package com.jaydot2.data.redisstorage.controller

import com.jaydot2.data.redisstorage.model.UserEntity
import com.jaydot2.data.redisstorage.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(var userService : UserService) {

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: String) : ResponseEntity<UserEntity> {
        val user : UserEntity? = userService.getUserById(id)
        return ResponseEntity.ok(user)
    }
}