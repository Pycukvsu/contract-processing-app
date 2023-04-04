package org.example;

import org.example.contracts.*;
import org.example.entitles.Gender;
import org.example.entitles.Human;
import org.example.parser.ParseCSV;
import org.example.repository.Storage;
import org.example.repository.comparators.*;
import org.example.repository.sorting.BubbleSort;
import org.example.repository.sorting.ISorted;
import org.example.repository.sorting.SelectionSort;
import org.example.repository.sorting.ShellSort;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;


public class Program {

    public static void main(String[] args) {
        // write your code here

    }

    public void addContractt(Storage storage) {
        Human human = new Human(69,
                "Иванов Иван Иванович",
                LocalDate.of(1980, 10, 10),
                Gender.MALE,
                "1414 555555",
                32);

        storage.addContract(new ContractWiredInternet(155,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2024, 10, 10),
                1,
                human,
                15
        ));

        storage.addContract(new ContractMobileCom(100,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2023, 10, 10),
                2,
                human,
                1000,
                400,
                50
        ));

        storage.addContract(new ContractDigitalTV(112,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2025, 10, 10),
                3,
                human,
                ChannelPackage.PLUS
        ));

        Human human2 = new Human(30,
                "Петрова Елена Петровна",
                LocalDate.of(2000, 10, 10),
                Gender.FEMALE,
                "1416 777777",
                22);

        storage.addContract(new ContractWiredInternet(200,
                LocalDate.of(2022, 10, 15),
                LocalDate.of(2024, 10, 10),
                4,
                human2,
                10
        ));

        storage.addContract(new ContractDigitalTV(205,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2026, 10, 10),
                5,
                human2,
                ChannelPackage.PREMIUM
        ));

        storage.addContract(new ContractMobileCom(210,
                LocalDate.of(2019, 9, 15),
                LocalDate.of(2023, 9, 10),
                6,
                human2,
                800,
                300,
                40
        ));
    }

    /**
     * Тест удаления контрактов по айди
     */
    public void deletionTest() {
        Storage storage = new Storage();

        storage.addContract(new ContractDigitalTV(123));
        storage.addContract(new ContractMobileCom(111));
        storage.addContract(new ContractWiredInternet(101));
        storage.addContract(new ContractWiredInternet(200));
        storage.addContract(new ContractDigitalTV(300));
        storage.addContract(new ContractDigitalTV(401));
        storage.addContract(new ContractMobileCom(56));
        storage.addContract(new ContractWiredInternet(700));

        storage.viewAllContracts();

        storage.deleteContractById(111);
        storage.deleteContractById(401);
        storage.deleteContractById(200);
        storage.deleteContractById(1000);

        storage.viewAllContracts();

        storage.addContract(new ContractWiredInternet(107));
        storage.addContract(new ContractDigitalTV(30));
        storage.addContract(new ContractWiredInternet(108));
        storage.viewAllContracts();
    }

    /**
     * Тест получения контрактов по айди
     */
    public void gettingByIdTest() {
        Storage storage = new Storage();

        storage.addContract(new ContractDigitalTV(123));
        storage.addContract(new ContractMobileCom(111));
        storage.addContract(new ContractWiredInternet(101));
        storage.addContract(new ContractWiredInternet(200));
        storage.addContract(new ContractDigitalTV(300));
        storage.addContract(new ContractDigitalTV(401));
        storage.addContract(new ContractMobileCom(56));
        storage.addContract(new ContractWiredInternet(700));

        storage.viewAllContracts();

        storage.getContractById(111);
        storage.getContractById(200);
        storage.getContractById(300);
        storage.getContractById(1000);

        System.out.println();

    }

    /**
     * Тест всего функционала
     */
    public void testAllFunctionality() {
        Storage storage = new Storage();

        addContractt(storage);

        storage.viewAllContracts();

        storage.getContractById(205);

        storage.deleteContractById(205);

        storage.viewAllContracts();
    }

    /**
     * Тест метода find()
     */
    public void TestFindMethod() {
        Storage storage = new Storage();

        Human human = new Human(69,
                "Иванов Иван Иванович÷",
                LocalDate.of(1980, 10, 10),
                Gender.MALE,
                "1414 555555",
                32);

        storage.addContract(new ContractWiredInternet(155,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2024, 10, 10),
                1,
                human,
                15
        ));

        storage.addContract(new ContractMobileCom(100,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2023, 10, 10),
                2,
                human,
                1000,
                400,
                50
        ));

        storage.addContract(new ContractDigitalTV(112,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2025, 10, 10),
                3,
                human,
                ChannelPackage.PLUS
        ));

        storage.viewAllContracts();

        Human human2 = new Human(30,
                "Петрова Елена Петровна",
                LocalDate.of(2000, 10, 10),
                Gender.FEMALE,
                "1416 777777",
                22);

        storage.addContract(new ContractWiredInternet(200,
                LocalDate.of(2022, 10, 15),
                LocalDate.of(2024, 10, 10),
                4,
                human2,
                10
        ));

        storage.addContract(new ContractDigitalTV(205,
                LocalDate.of(2020, 10, 15),
                LocalDate.of(2026, 10, 10),
                5,
                human2,
                ChannelPackage.PREMIUM
        ));

        storage.addContract(new ContractMobileCom(210,
                LocalDate.of(2019, 9, 15),
                LocalDate.of(2023, 9, 10),
                6,
                human2,
                800,
                300,
                40
        ));

        System.out.println(1);
        Predicate<Contract> condition = field -> field.getEndDate().equals(LocalDate.of(2023, 9, 10));
        List<Contract> contracts = storage.find(condition);

        System.out.println(2);
        Predicate<Contract> condition2 = field -> field.getEndDate().isAfter(LocalDate.of(2023, 9, 10));
        List<Contract> contracts2 = storage.find(condition2);

        System.out.println(3);
        Predicate<Contract> condition3 = field -> field.getId() == 205;
        List<Contract> contracts3 = storage.find(condition3);

        System.out.println(4);
        Predicate<Contract> condition4 = field -> field.getId() >= 200;
        List<Contract> contracts4 = storage.find(condition4);

        System.out.println(5);
        Predicate<Contract> condition5 = field -> field.getContractOwner().equals(human);
        List<Contract> contracts5 = storage.find(condition5);
    }

    /**
     * Тест сортировок
     */
    public void testSorting() {
        Storage storage = new Storage();

        addContractt(storage);

        System.out.println("Первая сортировка: ");
        ISorted methodSort = new SelectionSort();
        methodSort.sort(storage, new MaxNumberContractComparator());
        storage.viewAllContracts();

        System.out.println("Вторая сортировка: ");
        ISorted methodSort2 = new BubbleSort();
        methodSort2.sort(storage, new MaxIdContractComparator());
        storage.viewAllContracts();

        System.out.println("Третья срптировка: ");
        ISorted methodSort3 = new ShellSort();
        methodSort3.sort(storage, new MaxStartDateComparator());
        storage.viewAllContracts();

        System.out.println("Четвертая сортировка: ");
        methodSort.sort(storage, new MaxEndDateComparator());
        storage.viewAllContracts();

        System.out.println("Пятая сортировка: ");
        methodSort2.sort(storage, new HumanIdComparator());
        storage.viewAllContracts();
    }

    public void testParser() throws FileNotFoundException {
        Storage storage = new Storage();
        FileReader fileReader = new FileReader("C:/Games/lab_2/ContractRepository/contracts.csv");
        ParseCSV par = new ParseCSV();
        par.parseFileCsv(storage, fileReader);
        storage.viewAllContracts();
    }
}
