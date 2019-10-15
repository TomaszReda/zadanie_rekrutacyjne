package pl.tomek_reda.zadanie_zaliczeniowe.file;

import pl.tomek_reda.zadanie_zaliczeniowe.constant.Constant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileData {

    private static final Logger LOGGER = Logger.getLogger(FileData.class.getName());

    public static List<Map<String, Double>> readDataFromFile() {
        List<Map<String, Double>> operationsAndNumbers = new ArrayList<>();
        try {
            File file = new File("operacje.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String data = "";
            while ((data = br.readLine()) != null)
                addDataToList(data, operationsAndNumbers);
        } catch (Exception ex) {
            LOGGER.warning(String.format("Problem with file %s", ex.getMessage()));
        }
        return operationsAndNumbers;
    }


    private static void addDataToList(String data, List<Map<String, Double>> operationsAndNumbers) {
        for (String operation : Constant.OPERATIONS)
            if (data.contains(operation))
                createOprationData(operationsAndNumbers, data, operation);
    }

    private static void createOprationData(List<Map<String, Double>> operationsAndNumbers, String data, String operation) {
        Map<String, Double> operationData = new HashMap<>();
        String number = findNumberInString(data);
        if (!number.equals("brak")) {
            operationData.put(operation, Double.parseDouble(number));
            operationsAndNumbers.add(operationData);
        }
    }

    private static String findNumberInString(String data) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(data);
        if (m.find())
            return m.group();
        return "brak";
    }

}
