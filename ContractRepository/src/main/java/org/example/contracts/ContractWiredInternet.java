package org.example.contracts;

import org.example.entitles.Human;

import java.time.LocalDate;

public class ContractWiredInternet extends Contract {

    private int connectSpeed;

    public int getConnectSpeed() {
        return connectSpeed;
    }

    public void setConnectSpeed(int connectSpeed) {
        this.connectSpeed = connectSpeed;
    }

    public ContractWiredInternet(int id, LocalDate startDate, LocalDate endDate, int numberContract, Human contractOwner, int connectSpeed) {
        super(id, startDate, endDate, numberContract, contractOwner);
        this.connectSpeed = connectSpeed;
    }

    public ContractWiredInternet(int id, LocalDate startDate, LocalDate endDate, int numberContract, Human contractOwner) {
        super(id, startDate, endDate, numberContract, contractOwner);
    }

    public ContractWiredInternet(LocalDate startDate, LocalDate endDate, Human contractOwner, int connectSpeed) {
        super(startDate, endDate, contractOwner);
        this.connectSpeed = connectSpeed;
    }

    public ContractWiredInternet(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "ContractWiredInternet{" +
                "id=" + getId() +
                ", startDate='" + getStartDate() + '\'' +
                ", endDate='" + getEndDate() + '\'' +
                ", numberContract='" + getNumberContract() + '\'' +
                ", contractOwner='" + getContractOwner() + '\'' +
                "connectSpeed=" + connectSpeed +
                '}';
    }


}
