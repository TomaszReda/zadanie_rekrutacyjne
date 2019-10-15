package pl.tomek_reda.zadanie_zaliczeniowe.constant;

import com.sun.corba.se.spi.orb.Operation;

import java.util.Arrays;
import java.util.List;

public class Constant {
    public static final String ADD = "add";
    public static final String MULTIPLE = "multiple";
    public static final String DIVIDE = "divide";
    public static final String SUBSTRACT = "substract";
    public static final String APPLY = "apply";
    public static final List<String> OPERATIONS = Arrays.asList(ADD, MULTIPLE, DIVIDE, SUBSTRACT, APPLY);
}
