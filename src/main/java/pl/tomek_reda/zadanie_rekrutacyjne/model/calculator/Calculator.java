package pl.tomek_reda.zadanie_rekrutacyjne.model.calculator;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.logging.Logger;

@Getter
@Setter
@AllArgsConstructor
public class Calculator implements ICalculator {

    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

    private double result;

    @Override
    public void add(double number) {
        try {
            System.err.print(" + " + number);
            setResult(getResult() + number);
        } catch (Exception ex) {
            LOGGER.warning(String.format("Error add %f%n to %f%n description: %s", getResult(), number, ex.getMessage()));
        }
    }

    @Override
    public void multiple(double number) {
        try {
            System.err.print(" * " + number);
            setResult(getResult() * number);
        } catch (Exception ex) {
            LOGGER.warning(String.format("Error multiple %f%n with %f%n description: %s", getResult(), number, ex.getMessage()));
        }
    }

    @Override
    public void divide(double number) {
        try {
            System.err.print(" / " + number);
            setResult(getResult() / number);
        } catch (Exception ex) {
            LOGGER.warning(String.format("Error divide %f%n from %f%n description: %s", getResult(), number, ex.getMessage()));
        }
    }

    @Override
    public void substract(double number) {
        try {
            System.err.print(" - " + number);
            setResult(getResult() - number);
        } catch (Exception ex) {
            LOGGER.warning(String.format("Error substract %f%n from %f%n description: %s", getResult(), number, ex.getMessage()));
        }
    }


}
