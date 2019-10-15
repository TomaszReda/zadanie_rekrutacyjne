package pl.tomek_reda.zadanie_zaliczeniowe.calculator;


import java.util.logging.Logger;

public class Calculator implements ICalculator {

    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

    private double result;

    public Calculator(double result) {
        this.result = result;
    }

    @Override
    public void add(double number) {
        try {
            setResult(getResult() + number);
        } catch (Exception ex) {
            LOGGER.warning(String.format("Error add %f%n to %f%n description: %s", getResult(), number, ex.getMessage()));
        }
    }

    @Override
    public void multiple(double number) {
        try {
            setResult(getResult() * number);
        } catch (Exception ex) {
            LOGGER.warning(String.format("Error multiple %f%n with %f%n description: %s", getResult(), number, ex.getMessage()));
        }
    }

    @Override
    public void divide(double number) {
        try {
            setResult(getResult() * number);
        } catch (Exception ex) {
            LOGGER.warning(String.format("Error divide %f%n from %f%n description: %s", getResult(), number, ex.getMessage()));
        }
    }

    @Override
    public void substract(double number) {
        try {
            setResult(getResult() - number);
        } catch (Exception ex) {
            LOGGER.warning(String.format("Error substract %f%n from %f%n description: %s", getResult(), number, ex.getMessage()));
        }
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
