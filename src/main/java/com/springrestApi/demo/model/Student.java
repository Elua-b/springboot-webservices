package com.springrestApi.demo.model;


import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student_table")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
    @Column(name = "age")
    private int age;


}
