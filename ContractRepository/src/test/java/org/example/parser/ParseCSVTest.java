package org.example.parser;


import org.example.entitles.Human;
import org.example.repository.Storage;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс юнит тест парсера Csv файлов
 *
 * @autor Хачетлов Руслан
 */
class ParseCSVTest {

    @org.junit.jupiter.api.Test
    void parseFileCsv() throws FileNotFoundException {
        Storage storage = new Storage();
        FileReader fileReader = new FileReader("C:/Games/lab_2/ContractRepository/src/test/java/org/example/parser/testContracts.csv");
        ParseCSV par = new ParseCSV();
        par.parseFileCsv(storage, fileReader);
        storage.viewAllContracts();

        assertEquals(2,storage.getNumberOfContracts());
    }
}