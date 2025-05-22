package com.example.persistence;


import java.sql.Connection;
import java.sql.CallableStatement;

public class AccessDAO {
    
    public void insert(final long employeeId, final long moduleId){
        try (
            Connection connection = ConnectionUtil.getConnection();
            CallableStatement statement = connection.prepareCall(
                "INSERT INTO  accesses (employee_id, module_id) values (?, ?);"
            )){
                statement.setLong(1, employeeId);
                statement.setLong(2, moduleId);


                statement.execute();
                
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }

    

    public void delete(final long id){
        
    }

}
