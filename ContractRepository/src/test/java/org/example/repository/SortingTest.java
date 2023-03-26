package org.example.repository;


import org.example.contracts.*;
import org.example.entitles.Gender;
import org.example.entitles.Human;
import org.example.repository.comparators.MaxIdContractComparator;
import org.example.repository.comparators.MaxNumberContractComparator;
import org.example.repository.comparators.MaxStartDateComparator;
import org.example.repository.sorting.BubbleSort;
import org.example.repository.sorting.ISorted;
import org.example.repository.sorting.SelectionSort;
import org.example.repository.sorting.ShellSort;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

/**
 * UnitTest сортировок
 *
 * @autor Хачетлов Руслан
 */
class SortingTest {

    @org.junit.jupiter.api.Test
    void bubbleSort(){
        Contract contract = new Contract(1,LocalDate.of(2015, 1, 1));
        Contract contract2 = new Contract(2,LocalDate.of(2016, 1, 1));
        Contract contract3 = new Contract(3,LocalDate.of(2017, 1, 1));
        Contract contract4 = new Contract(4,LocalDate.of(2018, 1, 1));

        Storage storage = new Storage();
        Contract[] contracts = new Contract[10];

        addContractInStorage(contract, contract2, contract3, contract4, storage);
        addContractInArray(contract, contract2, contract3, contract4, contracts);

        ISorted bubbleSort = new BubbleSort();
        bubbleSort.sort(storage, new MaxStartDateComparator());

        assertArrayEquals(contracts, storage.getStorage());
        storage.viewAllContracts();
    }

    @org.junit.jupiter.api.Test
    void ShellSort(){
        Contract contract = new Contract(10, 1);
        Contract contract2 = new Contract(20,2);
        Contract contract3 = new Contract(30,3);
        Contract contract4 = new Contract(40,4);

        Storage storage = new Storage();
        Contract[] contracts = new Contract[10];

        addContractInStorage(contract, contract2, contract3, contract4, storage);
        addContractInArray(contract, contract2, contract3, contract4, contracts);

        ISorted shellSort = new ShellSort();
        shellSort.sort(storage, new MaxNumberContractComparator());

        assertArrayEquals(contracts, storage.getStorage());
        storage.viewAllContracts();
    }

    @org.junit.jupiter.api.Test
    void selectionSort() {
        Contract contract = new Contract(10);
        Contract contract2 = new Contract(20);
        Contract contract3 = new Contract(30);
        Contract contract4 = new Contract(40);

        Storage storage = new Storage();
        Contract[] contracts = new Contract[10];

        addContractInStorage(contract, contract2, contract3, contract4, storage);
        addContractInArray(contract, contract2, contract3, contract4, contracts);

        ISorted selectionSort = new SelectionSort();
        selectionSort.sort(storage, new MaxIdContractComparator());

        assertArrayEquals(contracts, storage.getStorage());
        storage.viewAllContracts();
    }

    void addContractInStorage(Contract contract, Contract contract2, Contract contract3, Contract contract4, Storage storage) {
        storage.addContract(contract2);
        storage.addContract(contract);
        storage.addContract(contract4);
        storage.addContract(contract3);
    }

    void addContractInArray(Contract contract, Contract contract2, Contract contract3, Contract contract4, Contract[] contracts) {
        contracts[0] = contract4;
        contracts[1] = contract3;
        contracts[2] = contract2;
        contracts[3] = contract;
    }
}
