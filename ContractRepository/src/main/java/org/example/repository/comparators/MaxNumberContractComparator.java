package org.example.repository.comparators;

import org.example.contracts.Contract;

import java.util.Comparator;

public class MaxNumberContractComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        return o2.getNumberContract() - o1.getNumberContract();
    }
}
