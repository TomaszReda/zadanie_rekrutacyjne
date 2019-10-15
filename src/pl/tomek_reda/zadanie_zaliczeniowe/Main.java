package pl.tomek_reda.zadanie_zaliczeniowe;

import pl.tomek_reda.zadanie_zaliczeniowe.file.FileData;
import pl.tomek_reda.zadanie_zaliczeniowe.operation.Operation;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Operation operation = new Operation(FileData.readDataFromFile());
        operation.operation();
    }
}
