package org.example.repository.comparators;

import org.example.contracts.Contract;

import java.util.Comparator;

public class MaxIdContractComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        return o2.getId() - o1.getId();
    }
}
