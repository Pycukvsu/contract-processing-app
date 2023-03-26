package org.example.repository.sorting;

import org.example.contracts.Contract;
import org.example.repository.Storage;

import java.util.Comparator;

/**
 * Пузырьковая сортировка
 *
 * @autor Хачетлов Руслан
 */
public class BubbleSort implements ISorted {
    @Override
    public void sort(Storage storage, Comparator<Contract> comparator) {
        for (int i = 0; i < storage.getStorage().length - 1; i++) {
            for (int j = 0; j < storage.getStorage().length - i - 1; j++) {
                if (storage.getStorage()[j + 1] != null) {
                    if (comparator.compare(storage.getStorage()[j + 1], storage.getStorage()[j]) < 0) {
                        Contract temp = storage.getStorage()[j + 1];
                        storage.getStorage()[j + 1] = storage.getStorage()[j];
                        storage.getStorage()[j] = temp;

                    }
                }
            }
        }
    }
}
