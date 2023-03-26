package org.example.repository.sorting;

import org.example.contracts.Contract;
import org.example.repository.Storage;

import java.util.Comparator;

public interface ISorted {

    void sort(Storage storage, Comparator<Contract> comparator);

}
