package com.example.persistence.entity;

import java.time.OffsetDateTime;
import java.math.BigDecimal;

public record EmployeeAuditEntity(
    long employee_id,
    String nome,
    String old_nome,
    BigDecimal salary,
    BigDecimal old_salary,
    OffsetDateTime birthday,
    OffsetDateTime old_birthday,
    OperationEnum operation
) {

    
}
