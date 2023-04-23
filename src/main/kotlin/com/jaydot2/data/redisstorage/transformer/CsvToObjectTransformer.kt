package com.jaydot2.data.redisstorage.transformer

import com.jaydot2.data.redisstorage.model.UserEntity
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileReader

class CsvToObjectTransformer {

    val log = LoggerFactory.getLogger(CsvToObjectTransformer::class.java)

    enum class UserHeader{
        Id, FirstName, LastName, MiddleName
    }

    fun createUserEntityListFromCSV(input: File): MutableList<UserEntity?>? {
        log.info("loading CSV file into UserEntity list...")
        val reader: FileReader = FileReader(input)
        val csvFormat: CSVFormat = CSVFormat.EXCEL.builder().setHeader().setSkipHeaderRecord(true).build()
        val csvParser: CSVParser = CSVParser.parse(reader, csvFormat)


        var userEntityList : MutableList<UserEntity?>? = mutableListOf()
        for (csvRecord in csvParser) {
            var userEntity: UserEntity = UserEntity(csvRecord.get(0), csvRecord.get(1),csvRecord.get(2),csvRecord.get(3))
            userEntityList?.add(userEntity)
        }

        return userEntityList
    }
}