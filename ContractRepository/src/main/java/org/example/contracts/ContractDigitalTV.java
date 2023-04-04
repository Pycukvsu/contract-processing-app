package org.example.contracts;

import org.example.entitles.Human;

import java.time.LocalDate;

public class ContractDigitalTV extends Contract {

    private ChannelPackage channelPackage;

    public ChannelPackage getChannelPackage() {
        return channelPackage;
    }

    public void setChannelPackage(ChannelPackage channelPackage) {
        this.channelPackage = channelPackage;
    }

    public ContractDigitalTV(int id, LocalDate startDate, LocalDate endDate, int numberContract, Human contractOwner, ChannelPackage channelPackage) {
        super(id, startDate, endDate, numberContract, contractOwner);
        this.channelPackage = channelPackage;
    }

    public ContractDigitalTV(LocalDate startDate, LocalDate endDate, Human contractOwner, ChannelPackage channelPackage) {
        super(startDate, endDate, contractOwner);
        this.channelPackage = channelPackage;
    }

    public ContractDigitalTV(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return  "ContractDigitalTV{" +
                "id=" + getId() +
                ", startDate='" + getStartDate() + '\'' +
                ", endDate='" + getEndDate() + '\'' +
                ", numberContract='" + getNumberContract() + '\'' +
                ", contractOwner='" + getContractOwner() + '\'' +
                "channelPackage=" + channelPackage +
                '}';
    }
}
