package org.example.repository.comparators;

import org.example.contracts.Contract;

import java.util.Comparator;

public class MaxStartDateComparator implements Comparator<Contract> {

    @Override
    public int compare(Contract o1, Contract o2) {
        if (o2.getStartDate().isAfter(o1.getStartDate())) {
            return 1;
        }else if (!o2.getStartDate().isAfter(o1.getStartDate())){
            return -1;
        }else
            return 0;
    }
}
