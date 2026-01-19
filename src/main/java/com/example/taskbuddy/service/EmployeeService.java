package com.example.taskbuddy.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskbuddy.exception.EmployeeNotFoundException;
import com.example.taskbuddy.model.Employee;

@Service
public class EmployeeService {

    // Collections: Using ArrayList to store employee objects in-memory
    private final List<Employee> employees = new ArrayList<>();

    // File Handling: Path to file storing employees
    private final String filePath = "employees.txt";

    // OOP: Variable for auto-incrementing ID for new employees
    private int nextId = 1;

    public EmployeeService() {
        loadFromFile(); // File Handling: Load employees on startup
        if (!employees.isEmpty()) {
            // Collections + OOP: Find max ID in list for next employee's ID
            nextId = employees.stream().mapToInt(Employee::getId).max().getAsInt() + 1;
        }
    }

    // CRUD Operation: Get all employees
    public List<Employee> getAll() {
        return employees;
    }

    // CRUD Operation + Exception Handling: Get employee by ID or throw custom exception
    public Employee getById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
    }

    // CRUD Operation + Collections + File Handling: Add new employee and save to file
    public Employee create(Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
        saveToFile();
        return employee;
    }

    // CRUD Operation + Collections + File Handling: Update employee info and save
    public Employee update(int id, Employee updated) {
        Employee emp = getById(id);
        emp.setName(updated.getName());
        emp.setEmail(updated.getEmail());
        emp.setPhone(updated.getPhone());
        saveToFile();
        return emp;
    }

    // CRUD Operation + Exception Handling + File Handling: Remove employee and update file
    public void delete(int id) {
        Employee emp = getById(id);
        employees.remove(emp);
        saveToFile();
    }

    // File Handling + String Manipulation: Write all employees to file
    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee emp : employees) {
                // String Manipulation: Create CSV line from employee fields
                String line = emp.getId() + "," + emp.getName() + "," + emp.getEmail() + "," + emp.getPhone();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Exception Handling: Log IO exceptions
        }
    }

    // File Handling + String Manipulation: Load employees from file, parsing CSV lines
    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return; // Exception Handling: handle missing file gracefully

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // String Manipulation: Split CSV line into parts
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Employee emp = new Employee(
                            Integer.parseInt(parts[0]),
                            parts[1],
                            parts[2],
                            parts[3]
                    );
                    employees.add(emp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Exception Handling: Log IO exceptions
        }
    }
}

