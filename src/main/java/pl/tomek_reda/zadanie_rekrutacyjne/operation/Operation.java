package pl.tomek_reda.zadanie_rekrutacyjne.operation;

import pl.tomek_reda.zadanie_rekrutacyjne.model.calculator.Calculator;
import pl.tomek_reda.zadanie_rekrutacyjne.constant.Constant;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Operation {

    private Calculator calculator;

    List<Map<String, Double>> operationsAndNumbers;

    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());


    public Operation(List<Map<String, Double>> operationsAndNumbers) {
        this.operationsAndNumbers = operationsAndNumbers;
    }

    public void operation() {
        createCalculatorObject();
        takeOperation();
        if (calculator != null)
            System.err.println(" = " + calculator.getResult());
    }

    private void takeOperation() {
        if (calculator != null) {
            System.err.print(calculator.getResult());
            for (Map<String, Double> operationAndNumber : operationsAndNumbers)
                for (String key : operationAndNumber.keySet())
                    choseOperation(key, operationAndNumber);
        }
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
        } else {
            LOGGER.warning("Could't not find apply so calculator object is null");
        }
    }

}
