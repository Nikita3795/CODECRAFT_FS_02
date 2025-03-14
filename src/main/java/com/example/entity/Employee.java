 package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employees") // Equivalent to @Table(name = "employees") in JPA
public class Employee {

    @Id
    private String id; // MongoDB uses String (ObjectId), not Long

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format") // Ensure correct email format
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Department is required")
    private String department;
}
