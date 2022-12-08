package com.ex.company.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Department {

    @Id
    @SequenceGenerator(
            name = "dep_sequence",
            sequenceName = "dep_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dep_sequence"
    )
    private Long id;
    private String name;
    public Department() {
        super();
    }
    public Department(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name  + "]";
    }

}