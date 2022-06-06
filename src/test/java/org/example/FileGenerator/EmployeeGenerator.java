package org.example.FileGenerator;

import org.example.Resources.Constants;
import java.util.Random;

public class EmployeeGenerator {
    public static String stringGenerator(int length) {
        int startLimit = 97, endLimit = 122;
        Random random = new Random();
        String generatedString = random.ints(startLimit, endLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
    public static String emailGenerator() {
        return stringGenerator(10) + Constants.Generator.EmailDomain;
    }
    public static String nameGenerator() {
        return stringGenerator(1).toUpperCase() + stringGenerator(9);
    }
    public static String groupGenerator() {
        return Constants.Generator.GroupName[(int)(Math.random()*4)];
    }
    public static Employee employeeGenerator() {
        Employee employee = new Employee();
        employee.setFirstName(nameGenerator());
        employee.setLastName(nameGenerator());
        employee.setMiddleName(nameGenerator());
        employee.setEmail(emailGenerator());
        employee.setGroupName(groupGenerator());
        return employee;
    }
}


