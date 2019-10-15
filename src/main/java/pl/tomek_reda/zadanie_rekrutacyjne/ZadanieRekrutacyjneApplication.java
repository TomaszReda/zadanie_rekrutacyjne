package pl.tomek_reda.zadanie_rekrutacyjne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.tomek_reda.zadanie_rekrutacyjne.file.FileData;
import pl.tomek_reda.zadanie_rekrutacyjne.operation.Operation;

@SpringBootApplication
public class ZadanieRekrutacyjneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZadanieRekrutacyjneApplication.class, args);
        System.err.println("                  ");
        Operation operation = new Operation(FileData.readDataFromFile());
        operation.operation();
    }

}
