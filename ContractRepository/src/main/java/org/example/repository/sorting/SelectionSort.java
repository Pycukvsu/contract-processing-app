package org.example.repository.sorting;

import org.example.contracts.Contract;
import org.example.repository.Storage;

import java.util.Comparator;

/**
 * Сортировка Выбором
 *
 * @autor Хачетлов Руслан
 */
public class SelectionSort implements ISorted {

    @Override
    public void sort(Storage storage, Comparator<Contract> comparator) {
        for (int i = 0; i < storage.getStorage().length; i++) {
            int pos = i;
            Contract min = storage.getStorage()[i];
            for (int j = i + 1; j < storage.getStorage().length; j++) {
                if (storage.getStorage()[j] != null) {
                    if (comparator.compare(storage.getStorage()[j], min) < 0) {
                        pos = j;
                        min = storage.getStorage()[j];
                    }
                }
            }
            storage.getStorage()[pos] = storage.getStorage()[i];
            storage.getStorage()[i] = min;
        }
    }
}
