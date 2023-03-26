package org.example.contracts;

import org.example.entitles.Human;

import java.time.LocalDate;

public class ContractMobileCom extends Contract {

    private int minutes;
    private int sms;
    private int gigabytes;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSms() {
        return sms;
    }

    public void setSms(int sms) {
        this.sms = sms;
    }

    public int getGigabytes() {
        return gigabytes;
    }

    public void setGigabytes(int gigabytes) {
        this.gigabytes = gigabytes;
    }

    public ContractMobileCom(int id, LocalDate startDate, LocalDate endDate, int numberContract, Human contractOwner, int minutes, int sms, int gigabytes) {
        super(id, startDate, endDate, numberContract, contractOwner);
        this.minutes = minutes;
        this.sms = sms;
        this.gigabytes = gigabytes;
    }

    public ContractMobileCom(int id, LocalDate startDate, LocalDate endDate, int numberContract, Human contractOwner) {
        super(id, startDate, endDate, numberContract, contractOwner);
    }

    public ContractMobileCom(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "ContractMobileCom{" +
                "id=" + getId() +
                ", startDate='" + getStartDate() + '\'' +
                ", endDate='" + getEndDate() + '\'' +
                ", numberContract='" + getNumberContract() + '\'' +
                ", contractOwner='" + getContractOwner() + '\'' +
                "minutes=" + minutes +
                ", sms=" + sms +
                ", gigabytes=" + gigabytes +
                '}';
    }
}
