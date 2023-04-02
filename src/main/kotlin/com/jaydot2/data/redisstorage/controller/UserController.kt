package com.jaydot2.data.redisstorage.controller

import com.jaydot2.data.redisstorage.model.UserEntity
import com.jaydot2.data.redisstorage.service.UserService
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RequestMapping("/user")
@RestController
class UserController(var userService : UserService) {

    private val log = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: String) : ResponseEntity<UserEntity> {
        log.info("Request user by id ${id}")
        val user : UserEntity? = userService.getUserById(id)
        return ResponseEntity.ok(user)
    }

    @GetMapping("/save/{id}")
    fun saveDefaultUser(@PathVariable id: String) : ResponseEntity<String> {
        log.info("Request save of default user...")
        userService.saveDefaultUser(id)
        return ResponseEntity.accepted().body(id)
    }

    @GetMapping("/load")
    fun loadData() {
        log.info("load data from file...")
        userService.loadData()
    }
}