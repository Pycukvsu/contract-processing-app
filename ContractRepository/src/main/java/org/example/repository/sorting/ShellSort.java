package org.example.repository.sorting;

import org.example.contracts.Contract;
import org.example.repository.Storage;

import java.util.Comparator;

public class ShellSort implements ISorted {
    @Override
    public void sort(Storage storage, Comparator<Contract> comparator) {
        int gap = storage.getStorage().length / 2;
        while (gap >= 1) {
            for (int right = 0; right < storage.getStorage().length; right++) {
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (storage.getStorage()[c] != null && storage.getStorage()[c + gap] != null) {
                        if (comparator.compare(storage.getStorage()[c], storage.getStorage()[c + gap]) > 0) {
                            Contract temp = storage.getStorage()[c + gap];
                            storage.getStorage()[c + gap] = storage.getStorage()[c];
                            storage.getStorage()[c] = temp;
                        }
                    }
                }
            }
            gap = gap / 2;
        }
    }
}
