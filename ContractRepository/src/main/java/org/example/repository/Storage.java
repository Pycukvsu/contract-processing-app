package org.example.repository;

import org.example.contracts.Contract;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс хранилище
 *
 * @autor Хачетлов Руслан
 */

public class Storage {
    private Contract[] storage = new Contract[10];
    private int numberOfContracts = 0;


    /**
     * Метод расширение хранилища
     */
    private void expandStorage() {
        Contract[] newStorage = new Contract[storage.length];
        System.arraycopy(storage,0,newStorage,0,storage.length);
        storage = new Contract[storage.length * 4];
        System.arraycopy(newStorage, 0, storage, 0, newStorage.length);
    }


    /**
     * Метод проверяет, находится ли такой контракт уже в хранилище контракт с таким же айди
     *
     * @param id - айди контракт
     * @return flag - если флаг true - контракта нет в хранилище
     */
    private boolean isContractIdInStorage(int id) {
        boolean flag = true;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getId() == id) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    /**
     * Метод добавляет контракт в хранилище
     * Если не хватает места, массив расширяется
     * @param contract - контракт
     */
    public void addContract(Contract contract) {
        if (contract.getId() == 0){
            boolean flag = false;
            while (!flag){
                int id = (int) (Math.random() * 300);
                if (isContractIdInStorage(id)){
                    contract.setId(id);
                    flag = true;
                }
            }
        }
        if (contract.getNumberContract() == 0){
            contract.setNumberContract(numberOfContracts + 1);
        }
        if (isContractIdInStorage(contract.getId())) {
            if (numberOfContracts == storage.length) {
                expandStorage();
                storage[numberOfContracts] = contract;
            } else {
                storage[numberOfContracts] = contract;
            }
            numberOfContracts++;
        } else System.out.println("Контракт с таким айди уже есть в хранилище");
    }

    /**
     * Метод удаояет контракт по айди
     *
     * @param id - айди контракта
     */
    public void deleteContractById(int id) {
        boolean flag = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getId() == id) {
                    storage[i] = storage[numberOfContracts-1];
                    storage[numberOfContracts-1] = null;
                    System.out.println("Контракт успешно удален");
                    flag = true;
                    numberOfContracts--;
                }
            }
        }
        if (!flag) {
            System.out.println("Контракта с таким айди нет в хранилище");
        }
    }

    /**
     * Получение контракта по айди
     *
     * @param id - айди котракта
     */
    public Contract getContractById(int id) {
        Contract contract = null;
        boolean flag = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].getId() == id) {
                    System.out.println(storage[i]);
                    flag = true;
                    contract = storage[i];
                }
            }
        }
        if (!flag) {
            System.out.println("Контракта с таким айди нет в хранилище");
        }
        return contract;
    }

    /**
     * Вывод всех контрактов
     */
    public void viewAllContracts() {
        System.out.println("Хранилище: ");
        System.out.println();
        for (int i = 0; i < numberOfContracts; i++) {
            System.out.println((i + 1) + ". " + storage[i]);
        }
        System.out.println();
        System.out.println("Размер хранилища: " + storage.length);
        System.out.println();
    }

    /**
     * Метод поиска контрактов по заданому условию, переданный через предикат
     *
     * @param condition - условие поиска
     * @return contracts - список контрактов
     */
    public <T> List<Contract> find(Predicate<T> condition) {
        List<Contract> contracts = new ArrayList<>();
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && condition.test((T) storage[i])) {
                contracts.add(storage[i]);
            }
        }

        System.out.println("Результат поиска: ");

        if (contracts.isEmpty()) {
            System.out.println("Ничего не было найдено");
        }else {
            Iterator<Contract> it = contracts.listIterator();
            Contract contract;
            while (it.hasNext()) {
                contract = it.next();
                System.out.println(contract);
            }
        }
        System.out.println();
        return contracts;
    }

    public Contract[] getStorage() {
        return storage;
    }

    public int getNumberOfContracts() {
        return numberOfContracts;
    }
}
