package com.example.persistence.entity;

import java.util.List;

import lombok.Data;

@Data
public class ModuleEntity {
    private long id;

    private String name;

    private List<EmployeeEntity> employees;
}
