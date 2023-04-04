package org.example.parser;

import org.example.contracts.*;
import org.example.entitles.Gender;
import org.example.entitles.Human;
import org.example.repository.Storage;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс парсер Csv файлов
 *
 * @autor Хачетлов Руслан
 */
public class ParseCSV {

    /**
     * Метод читает файл и получает список массивов строк.
     * Массив строк передаётся в метод parseContract() который возвращает список распаршеных контрактов.
     * Добавляем этот список в хранилище.
     * @param storage - хранилище
     * @param file - прочитанный файл
     */
    public void parseFileCsv(Storage storage, FileReader file) {
        List<String[]> lineSplit = readCSV(file);
        if (lineSplit.size() != 0) {
            List<Contract> parsedContracts = parseContract(lineSplit);
            Iterator<Contract> it = parsedContracts.listIterator();
            Contract el;
            while (it.hasNext()){
                el = it.next();
                storage.addContract(el);
            }
        } else {
            System.out.println("Файл пустой :)");
        }
    }

    /**
     * Метод читает файл строкам.
     * Строки сплитятся по ; и элементы добавляются в список стринговых массивов.
     * @param file - прочитанный файл
     * @return listParseLine - список массивов, разбитых на элементы строкю.
     */
    private List<String[]> readCSV(FileReader file) {
        try (BufferedReader reader = new BufferedReader(file)) {
            String line = reader.readLine();
            List<String[]> listParseLine = new ArrayList<>();
            while (line != null) {
                String[] splitLine = line.split(";");
                if (splitLine.length != 1) {
                    listParseLine.add(splitLine);
                }
                line = reader.readLine();
            }
            return listParseLine;
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод создает из передаваемого списка массивов строк, контракты.
     * Метод определяет тип контракта и создаёт для него нужный контракт.
     * @param lineSplit - список массивов строк.
     * @return listParseLine - список массивов, разбитых на элементы строкю.
     */
    private List<Contract> parseContract(List<String[]> lineSplit) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        Human human;
        String[] temp = new String[1];
        String[] el;
        List<Contract> contracts = new ArrayList<>();

        Iterator<String[]> it = lineSplit.listIterator();
        while (it.hasNext()) {
            el = it.next();
            if (el.length != 2) {
                human = new Human(el[0], parseGender(el[1]), LocalDate.parse(el[2], formatter), el[3]);
                if (el[4].equals("Tv")) {
                    contracts.add(new ContractDigitalTV(
                            LocalDate.parse(temp[0], formatter),
                            LocalDate.parse(temp[1], formatter),
                            human,
                            parseChannelPackage(el[5])));
                } else if (el[4].equals("Mobile")) {
                    contracts.add(new ContractMobileCom(
                            LocalDate.parse(temp[0], formatter),
                            LocalDate.parse(temp[1], formatter),
                            human,
                            Integer.parseInt(el[5]),
                            Integer.parseInt(el[6]),
                            Integer.parseInt(el[7])));
                } else if (el[4].equals("Internet")) {
                    contracts.add(new ContractWiredInternet(
                            LocalDate.parse(temp[0], formatter),
                            LocalDate.parse(temp[1], formatter),
                            human,
                            Integer.parseInt(el[5])));
                }
            } else {
                temp = el;
            }
        }

        return contracts;
    }

    /**
     * Метод определяет гендер человека по переданому элементу.
     * @param el - строка
     * @return Gender.
     */
    private Gender parseGender(String el) {
        if (el.equals("MALE")) {
            return Gender.MALE;
        } else if (el.equals("FEMALE")) {
            return Gender.FEMALE;
        }
        return null;
    }

    /**
     * Метод определяет пакет тв.
     * @param el - строка
     * @return ChannelPackage.
     */
    private ChannelPackage parseChannelPackage(String el) {
        switch (el) {
            case "BEST":
                return ChannelPackage.BEST;
            case "PLUS":
                return ChannelPackage.PLUS;
            case "PREMIUM":
                return ChannelPackage.PREMIUM;
            case "TOP":
                return ChannelPackage.TOP;
        }
        return null;
    }
}
