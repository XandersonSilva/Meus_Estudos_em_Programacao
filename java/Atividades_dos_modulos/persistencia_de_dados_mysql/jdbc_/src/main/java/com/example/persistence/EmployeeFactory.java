package com.example.persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Locale;

import com.example.persistence.entity.EmployeeEntity;

import net.datafaker.Faker;


import static java.time.ZoneOffset.UTC;


public class EmployeeFactory{
    private final static Faker faker = new Faker(new Locale("pt","BR"));
    public static EmployeeEntity createEmployee(){
        EmployeeEntity employee = new EmployeeEntity();
            employee.setNome(faker.name().fullName());
            employee.setSalary(new BigDecimal(faker.number().digits(4)));
            employee.setBirthday(OffsetDateTime.now().minusYears(faker.number().numberBetween(10, 54)));
            return employee;
    }
}