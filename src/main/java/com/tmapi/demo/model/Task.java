package com.tmapi.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

}
