package com.bridgelabz.Serialization;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class SaveRetrieveObject {
    public static void main(String[] args) {
        String filename = "employees.ser";

        // Creating a list of employees
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 60000),
                new Employee(2, "Bob", "HR", 50000),
                new Employee(3, "Charlie", "Marketing", 55000)
        );

        // Serialize employees
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize employees
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Employee> loadedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Loaded Employees:");
            loadedEmployees.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
