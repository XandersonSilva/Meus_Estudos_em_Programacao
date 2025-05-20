package com.example.persistence.entity;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class EmployeeEntity {
    
    private  long id;
    
    private String nome;
    
    private BigDecimal salary;

    private OffsetDateTime birthday;

}
