package com.jaydot2.data.redisstorage.transformer

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import org.apache.commons.csv.CSVRecord
import java.io.File


import com.jaydot2.data.redisstorage.model.UserEntity
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CsvToObjectTransformerTest {

    private val transformer : CsvToObjectTransformer = CsvToObjectTransformer()

    private val USERS_MAP : Map<String, String> = mapOf("id" to "101", "firstName" to "John", "lastName" to "Doe", "middleName" to "J")

    enum class UserHeaders{
        id,
        firstName,
        lastName,
        middleName
    }

    @Test
    fun givenCsv_whenTransformingCSV_thenPopulateMutableListWithUserEntityObjects() {
        //
        val userCsvFile : File = File("classpath:data/testData.csv")
        var cvsFormat: CSVFormat = CSVFormat.DEFAULT.builder().build()

        // When
        var actualUserList : MutableList<UserEntity?>? = transformer.createUserEntityListFromCSV()

        // Then
        assertTrue(actualUserList?.size == 5)
    }
}