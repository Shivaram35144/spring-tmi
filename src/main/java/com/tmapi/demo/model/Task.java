package com.tmapi.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JoinColumn(name="user_id", nullable=true)
    @JsonBackReference // to prevent infinite recursion during serialization when returning in postman (Optional). Omits back pointer; halts recursion
    private User user;

}
