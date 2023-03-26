package org.example.repository;

import org.example.contracts.*;
import org.example.entitles.Gender;
import org.example.entitles.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    @org.junit.jupiter.api.Test
    void addContract() {
        Contract contract = new Contract(10);
        Storage storage = new Storage();
        storage.addContract(contract);

        Contract[] arr = new Contract[10];
        arr[0] = contract;

        assertArrayEquals(arr, storage.getStorage());
    }

    @org.junit.jupiter.api.Test
    void deleteContractById() {
        Contract contract = new Contract(10);
        Storage storage = new Storage();
        storage.addContract(contract);
        storage.deleteContractById(10);

        Contract[] arr = new Contract[10];
        arr[0] = contract;
        arr[0] = null;

        assertArrayEquals(arr, storage.getStorage());
    }

    @org.junit.jupiter.api.Test
    void getContractById() {
        Contract contract = new Contract(10);
        Storage storage = new Storage();
        storage.addContract(contract);

        assertEquals(contract, storage.getContractById(10));
    }

    @org.junit.jupiter.api.Test
    void find() {
        Storage storage = new Storage();
        Contract contract = new Contract(10);
        Contract contract2 = new Contract(15);
        Contract contract3 = new Contract(20);

        storage.addContract(contract);
        storage.addContract(contract2);
        storage.addContract(contract3);

        Predicate<Contract> condition = field -> field.getId() >= 15;
        List<Contract> contracts = storage.find(condition);

        List<Contract> list = new ArrayList<>();
        list.add(contract2);
        list.add(contract3);

        assertIterableEquals(list, contracts);
    }
}