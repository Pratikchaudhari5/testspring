package net.javaproject.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//to reduce boilerplate code
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")

public class Employee {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    //instance variables
    private Long id;

 @Column(name = "first_name") // used to give column name
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

}

//It is just like a card