package com.example;

import java.math.BigDecimal;
import java.sql.Connection;
import java.time.OffsetDateTime;
import java.util.List;

import com.example.persistence.ConnectionUtil;
import com.example.persistence.entity.EmployeeDAO;
import com.example.persistence.entity.EmployeeEntity;

import org.flywaydb.core.Flyway;

public class Main {
    private final static EmployeeDAO employeeDAO = new EmployeeDAO();

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                    .dataSource("jdbc:mysql://localhost:3306/jdbc", "root", "root")
                    .load();
        flyway.migrate();

        

        //EmployeeEntity entities = employeeDAO.findByID(2);
        // System.out.println(entities);

        EmployeeEntity entity = new EmployeeEntity();
        entity.setNome("joão");
        entity.setSalary(new BigDecimal("1551.5"));
        entity.setBirthday(OffsetDateTime.now().minusYears(26));


        employeeDAO.insert(entity);

        entity = new EmployeeEntity();
        entity.setNome("joão");
        entity.setSalary(new BigDecimal("1551.5"));
        entity.setBirthday(OffsetDateTime.now().minusYears(26));


        employeeDAO.insert(entity);

        entity = new EmployeeEntity();
        entity.setNome("paulo");
        entity.setSalary(new BigDecimal("5651.5"));
        entity.setBirthday(OffsetDateTime.now().minusYears(36));


        employeeDAO.insert(entity);

        entity = new EmployeeEntity();
        entity.setNome("Ana");
        entity.setSalary(new BigDecimal("3251.5"));
        entity.setBirthday(OffsetDateTime.now().minusYears(32));


        employeeDAO.insert(entity);

        entity = new EmployeeEntity();
        entity.setNome("Paulo");
        entity.setSalary(new BigDecimal("5251.5"));
        entity.setBirthday(OffsetDateTime.now().minusYears(56));


        employeeDAO.insert(entity);

        entity = new EmployeeEntity();
        entity.setId(3);
        entity.setNome("Cleiton");
        entity.setSalary(new BigDecimal("1541.5"));
        entity.setBirthday(OffsetDateTime.now().minusYears(31));

        employeeDAO.update(entity);

        employeeDAO.delete(2);
    }
}