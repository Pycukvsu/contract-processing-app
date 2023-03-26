package org.example.entitles;
import java.time.LocalDate;

/**
 * Класс человек с полями <b>id</b>, <b>FIO</b>, <b>dateOfBirth</b>, <b>gender</b>, <b>passportData</b> и <b>age</b>.
 * @autor Хачетлов Руслан
 */
public class Human {
    private int id;
    private String FIO;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String passportData;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human(int id, String FIO, LocalDate dateOfBirth, Gender gender, String passportData, int age) {
        this.id = id;
        this.FIO = FIO;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.passportData = passportData;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", FIO='" + FIO + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", passportData='" + passportData + '\'' +
                ", age=" + age +
                '}';
    }

    public Human() {
    }
}
