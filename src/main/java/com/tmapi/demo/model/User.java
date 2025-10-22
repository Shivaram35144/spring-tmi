package com.tmapi.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="users") // "user" is a reserved keyword in some SQL databases)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

}
