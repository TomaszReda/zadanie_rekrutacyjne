package pl.tomek_reda.zadanie_zaliczeniowe.operation;

import pl.tomek_reda.zadanie_zaliczeniowe.model.calculator.Calculator;
import pl.tomek_reda.zadanie_zaliczeniowe.constant.Constant;

import java.util.List;
import java.util.Map;

public class Operation {

    private Calculator calculator;

    List<Map<String, Double>> operationsAndNumbers;

    public Operation(List<Map<String, Double>> operationsAndNumbers) {
        this.operationsAndNumbers = operationsAndNumbers;
    }

    public void operation() {
        createCalculatorObject();
        takeOperation();
        System.err.println(" = " + calculator.getResult());
    }

    private void takeOperation() {
        System.err.print(calculator.getResult());
        for (Map<String, Double> operationAndNumber : operationsAndNumbers)
            for (String key : operationAndNumber.keySet())
                choseOperation(key, operationAndNumber);
    }

    private void choseOperation(String key, Map<String, Double> operationAndNumber) {
        switch (key) {
            case Constant.SUBSTRACT:
                calculator.substract(operationAndNumber.get(key));
                break;
            case Constant.ADD:
                calculator.add(operationAndNumber.get(key));
                break;
            case Constant.DIVIDE:
                calculator.divide(operationAndNumber.get(key));
                break;
            case Constant.MULTIPLE:
                calculator.multiple(operationAndNumber.get(key));
                break;
        }
    }

    private void createCalculatorObject() {
        Map<String, Double> operationApply = operationsAndNumbers.get(operationsAndNumbers.size() - 1);
        if (operationApply.containsKey(Constant.APPLY)) {
            calculator = new Calculator(operationApply.get(Constant.APPLY));
            operationsAndNumbers.remove(operationApply);
        }
    }

}
