package com.jaydot2.data.redisstorage.transformer

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jaydot2.data.redisstorage.model.UserEntity
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

class JsonToObjectTransformerTest {


    private val objectMapper: ObjectMapper = jacksonObjectMapper()
    private val jsonToObjectTransformer: JsonToObjectTransformer = JsonToObjectTransformer(objectMapper)

    @AfterEach
    fun tearDown() {
        // Remove temporary files
    }

    @Test
    fun givenJsonArray_whenTransformingJson_thenPopulateMutableListWithUserEntityObjects() {
        // Given
        val jsonArrayString: String = "[\n" +
                "  {\n" +
                "    \"id\": \"301\",\n" +
                "    \"firstName\": \"Tony\",\n" +
                "    \"lastName\": \"Stark\",\n" +
                "    \"middleName\": \"I\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"302\",\n" +
                "    \"firstName\": \"Bruce\",\n" +
                "    \"lastName\": \"Banner\",\n" +
                "    \"middleName\": \"B\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"303\",\n" +
                "    \"firstName\": \"Wanda\",\n" +
                "    \"lastName\": \"Maximoff\",\n" +
                "    \"middleName\": \"S\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"304\",\n" +
                "    \"firstName\": \"Carol\",\n" +
                "    \"lastName\": \"Danvers\",\n" +
                "    \"middleName\": \"M\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"305\",\n" +
                "    \"firstName\": \"Steve\",\n" +
                "    \"lastName\": \"Rogers\",\n" +
                "    \"middleName\": \"A\"\n" +
                "  }\n" +
                "]"
        var jsonArrayFile = File("src/test/resources/data/testData.json")
        jsonArrayFile.writeText(jsonArrayString)
        // When
        val listResult: MutableList<UserEntity> = jsonToObjectTransformer.createUserEntityListFromJsonArray(jsonArrayFile)
        // Then
        Assertions.assertTrue(listResult.size == 5)
    }
}