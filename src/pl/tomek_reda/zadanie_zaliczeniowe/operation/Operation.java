package pl.tomek_reda.zadanie_zaliczeniowe.operation;

import pl.tomek_reda.zadanie_zaliczeniowe.calculator.Calculator;
import pl.tomek_reda.zadanie_zaliczeniowe.constant.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Operation {

    private Calculator calculator;

    List<Map<String, Double>> operationAndNumber = new ArrayList<>();

    public Operation(List<Map<String, Double>> operationAndNumber) {
        this.operationAndNumber = operationAndNumber;
    }

    public void operation() {
        createCalculatoObject();
    }


    private void takeAction() {

    }

    private void createCalculatoObject() {
        Map<String, Double> operationApply = operationAndNumber.get(operationAndNumber.size() - 1);
        if (operationApply.containsKey(Constant.APPLY)) {
            calculator = new Calculator(operationApply.get(Constant.APPLY));
            operationAndNumber.remove(operationApply);
        }
    }


}
