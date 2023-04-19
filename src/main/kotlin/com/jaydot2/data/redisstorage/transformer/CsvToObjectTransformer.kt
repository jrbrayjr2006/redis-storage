package com.jaydot2.data.redisstorage.transformer

import com.jaydot2.data.redisstorage.model.UserEntity
import org.slf4j.LoggerFactory

class CsvToObjectTransformer {

    val log = LoggerFactory.getLogger(CsvToObjectTransformer::class.java)

    fun createUserEntityListFromCSV(): MutableList<UserEntity?>? {
        log.info("loading CSV file into UserEntity list...")
        var userEntityList : MutableList<UserEntity?>? = null
        return userEntityList
    }
}