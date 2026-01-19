package com.example.taskbuddy.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// OOP: Encapsulation with private fields and public getters/setters
public class Employee {

    private int id;

    @NotBlank(message = "Name is mandatory") // Regex + validation (annotation-based)
    private String name;

    @Email(message = "Invalid email format") // Regex validation
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number") // Regex validation
    private String phone;

    public Employee() {
    }

    // OOP: Constructor overloading (object creation with parameters)
    public Employee(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Getters and setters: OOP encapsulation
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
