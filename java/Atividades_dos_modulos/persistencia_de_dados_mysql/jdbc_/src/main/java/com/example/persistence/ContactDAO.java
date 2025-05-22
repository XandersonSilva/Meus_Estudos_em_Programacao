package com.example.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.ZoneOffset;

import com.example.persistence.entity.ContactEntity;
import com.example.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

public class ContactDAO {
    public void insert(final ContactEntity entity){
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO contacts (description, type, employee_id) values (?, ?, ?);"
            )){
                
                statement.setString(1, entity.getDescription());
                statement.setString(2, entity.getType());
                statement.setLong(3, entity.getEmployee().getId());
                statement.execute();
                if(statement instanceof StatementImpl impl){
                    entity.setId(impl.getLastInsertID());
                }
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }
    
}
