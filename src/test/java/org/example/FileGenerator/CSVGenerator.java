package org.example.FileGenerator;

import org.example.Resources.Constants;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.FileGenerator.EmployeeGenerator.*;

public class CSVGenerator {
    public static void CSVCoder(int countEmployees) {
        try(FileWriter writer = new FileWriter(Constants.Generator.PathToCSV, false))
        {
            writer.append(Constants.Generator.HeaderCSV + '\n');
            for (int iteration = 0; iteration < countEmployees; iteration++) {
                Employee employee = employeeGenerator();
                writer.append(employee.getFirstName() + ',');
                writer.append(employee.getLastName() + ',');
                writer.append(employee.getMiddleName() + ',');
                writer.append(employee.getEmail() + ',');
                writer.append(employee.getGroupName() + '\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public static ArrayList<Employee> CSVDecoder() {
        ArrayList<Employee> employeesList = new ArrayList<Employee>();
        try(FileReader reader = new FileReader(Constants.Generator.PathToCSV))
        {
            Scanner scanner = new Scanner(reader);
            for (int i = 1; scanner.hasNextLine(); i++) {
                String[] employeeString = scanner.nextLine().split(",");
                if (i != 1){
                    Employee employee = new Employee();
                    employee.setFirstName(employeeString[0]);
                    employee.setLastName(employeeString[1]);
                    employee.setMiddleName(employeeString[2]);
                    employee.setEmail(employeeString[3]);
                    employee.setGroupName(employeeString[4]);
                    employeesList.add(employee);
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return employeesList;
    }
}
