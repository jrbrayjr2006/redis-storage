package com.jaydot2.data.redisstorage.controller

import com.jaydot2.data.redisstorage.model.UserEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: String) : ResponseEntity<UserEntity> {
        val user = UserEntity(id, "Bob", "Jones", "P")
        return ResponseEntity.ok(user)
    }
}