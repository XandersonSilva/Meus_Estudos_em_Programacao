
package com.example;

import java.math.BigDecimal;
import java.sql.Connection;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import com.example.persistence.AccessDAO;
import com.example.persistence.ConnectionUtil;
import com.example.persistence.ContactDAO;
import com.example.persistence.EmployeeAuditDAO;
import com.example.persistence.EmployeeDAO;
import com.example.persistence.EmployeeFactory;
import com.example.persistence.EmployeeParamDAO;
import com.example.persistence.ModuleDAO;
import com.example.persistence.entity.ContactEntity;
import com.example.persistence.entity.EmployeeEntity;

import lombok.var;

import org.flywaydb.core.Flyway;

//import static java.time.ZoneOffset.UTC;


public class Main {
    private final static EmployeeParamDAO employeeParamDAO = new EmployeeParamDAO();
    private final static EmployeeDAO employeeDAO = new EmployeeDAO();
    private final static ContactDAO contactDAO = new ContactDAO();
    private final static ModuleDAO moduleDAO = new ModuleDAO();
    private final static AccessDAO accessDAO = new AccessDAO();

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                    .dataSource("jdbc:mysql://localhost:3306/jdbc", "root",  "root")
                    .load();
        flyway.migrate();

        

        
        // List<EmployeeEntity> entities  = Stream
        // .<EmployeeEntity>generate(EmployeeFactory::createEmployee)
        // .limit(100)
        // .toList();

        // employeeParamDAO.insert(entities);


        // moduleDAO.findAll().forEach(System.out::println);
    }
}