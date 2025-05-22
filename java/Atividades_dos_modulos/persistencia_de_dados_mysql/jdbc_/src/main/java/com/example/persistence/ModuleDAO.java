package com.example.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.example.persistence.entity.EmployeeEntity;
import com.example.persistence.entity.ModuleEntity;

public class ModuleDAO {
    public List<ModuleEntity> findAll(){
        String sql = "SELECT"
                      + " m.id module_id,"
                      + " m.name module_name,"
                      + " e.nome employee_nome,"
                      + " e.salary employee_salary,"
                      + " e.birthday employee_birthday "
                      + "FROM modules m INNER JOIN accesses a "
                      + " ON a.module_id = m.id"
                      + " INNER JOIN employees e "
                      + " ON e.id = a.employee_id ORDER BY m.id";
        List<ModuleEntity> entitys = new ArrayList<>();
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
                statement.executeQuery();
                ResultSet resultSet = statement.getResultSet();
                boolean hasNext = resultSet.next();
                while (hasNext) {
                    ModuleEntity entity = new ModuleEntity();
                    entity.setEmployees(new ArrayList<>());
                    entity.setId(resultSet.getLong("module_id"));
                    entity.setName(resultSet.getString("module_name"));

                    do{
                        EmployeeEntity employee = new EmployeeEntity();

                        employee.setNome(resultSet.getString("employee_nome"));
                        employee.setSalary(resultSet.getBigDecimal("employee_salary"));
                        Instant birthdayInstant = resultSet.getTimestamp("employee_birthday").toInstant();
                        employee.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, ZoneOffset.UTC));

                        entity.getEmployees().add(employee);
                        hasNext = resultSet.next();
                    }while(hasNext && entity.getId() == resultSet.getLong("module_id"));

                    entitys.add(entity);
                }
               
        } catch (Exception e) {
            System.out.println(e);
        }
        return entitys;
    }

}
