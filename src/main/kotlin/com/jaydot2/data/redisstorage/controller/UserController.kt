package com.jaydot2.data.redisstorage.controller

import com.jaydot2.data.redisstorage.model.UserEntity
import com.jaydot2.data.redisstorage.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
@RestController
class UserController(var userService : UserService) {

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String) : ResponseEntity<UserEntity> {
        val user : UserEntity? = userService.getUserById(id)
        return ResponseEntity.ok(user)
    }

    @GetMapping("/save/{id}")
    fun saveDefaultUser(@PathVariable id: String) : ResponseEntity<String> {
        userService.saveDefaultUser(id)
        return ResponseEntity.accepted().body(id)
    }
}