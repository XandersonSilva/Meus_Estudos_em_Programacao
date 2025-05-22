package com.example.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import com.example.persistence.entity.EmployeeEntity;
import com.example.persistence.entity.EmployeeAuditEntity;
import com.example.persistence.entity.OperationEnum;
import com.mysql.cj.jdbc.StatementImpl;

import java.util.ArrayList;
import java.util.List;



public class EmployeeAuditDAO {

    public void insert(final EmployeeEntity entity){
        try (
            Connection connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement()){
                String sql = "INSERT INTO employees (nome, salary, birthday) values ('"+
                 entity.getNome() +"', "+
                 entity.getSalary().toString() +", '"+
                 formatOffsetDateTime(entity.getBirthday()) +"'  )";

                statement.executeUpdate(sql);

                System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());
                if(statement instanceof StatementImpl impl){
                    entity.setId(impl.getLastInsertID());
                }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // public void insertWithProcedure(final EmployeeEntity entity){
    //     try (
    //         Connection connection = ConnectionUtil.getConnection();
    //         Statement statement = connection.createStatement()){
    //             String sql = "INSERT INTO employees (nome, salary, birthday) values ('"+
    //              entity.getNome() +"', "+
    //              entity.getSalary().toString() +", '"+
    //              formatOffsetDateTime(entity.getBirthday()) +"'  )";

    //             statement.executeUpdate(sql);

    //             System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());
    //             if(statement instanceof StatementImpl impl){
    //                 entity.setId(impl.getLastInsertID());
    //             }
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    // }

    public void update(final EmployeeEntity entity){
    try (
            Connection connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement()){
                String sql = "UPDATE employees set  " +
                " nome = '"   + entity.getNome()  +"'"+
                ", salary ="   + entity.getSalary().toString() +
                ", birthday ='" + formatOffsetDateTime(entity.getBirthday()) + "'"+
                "WHERE id=" +entity.getId();
                 

                statement.executeUpdate(sql);

                System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());
                if(statement instanceof StatementImpl impl){
                    entity.setId(impl.getLastInsertID());
                }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void delete(final long id){
try (
            Connection connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement()){
                String sql = "DELETE FROM employees WHERE id=" +id;

                statement.executeUpdate(sql);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public List<EmployeeAuditEntity> findAll(){
        List<EmployeeAuditEntity> entities = new ArrayList<>();
        try (
            Connection connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement()){
                String sql = "SELECT * FROM view_employee_audit";

                statement.executeQuery(sql);
                ResultSet resultSet = statement.getResultSet();

                while (resultSet.next()) {
                    
                    OffsetDateTime birthdayOffsetDateTime = 
                    Objects.isNull(resultSet.getTimestamp("birthday")) ? null :
                    OffsetDateTime.ofInstant(
                        resultSet.getTimestamp("birthday").toInstant(), ZoneOffset.UTC);

                    OffsetDateTime old_birthdayOffsetDateTime = 
                    Objects.isNull(resultSet.getTimestamp("old_birthday")) ? null :
                    OffsetDateTime.ofInstant(
                        resultSet.getTimestamp("old_birthday").toInstant(), ZoneOffset.UTC);
                    entities.add(
                                new EmployeeAuditEntity(
                                    resultSet.getLong("employee_id"),
                                    resultSet.getString("nome"),
                                    resultSet.getString("old_nome"),
                                    resultSet.getBigDecimal("salary"),
                                    resultSet.getBigDecimal("old_salary"),
                                    birthdayOffsetDateTime,
                                    old_birthdayOffsetDateTime,
                                    OperationEnum.getByDbOperation(resultSet.getString("operation"))                        
                        )
                    );
                }
               
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
        return entities;
    }

    public EmployeeEntity findByID(final long id){
        EmployeeEntity entity = new EmployeeEntity();
        try (
            Connection connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement()){
                String sql = "SELECT * FROM employees WHERE id="+id ;

                statement.executeQuery(sql);
                ResultSet resultSet = statement.getResultSet();
                if (resultSet.next()) {
                    
                    entity.setId(resultSet.getLong("id"));
                    entity.setNome(resultSet.getString("nome"));
                    entity.setSalary(resultSet.getBigDecimal("salary"));
                    Instant birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                    entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, ZoneOffset.UTC));
                }

               
        } catch (Exception e) {
            // TODO: handle exception
        }
        return entity;
    }

    private String formatOffsetDateTime(final OffsetDateTime dataTime){

        OffsetDateTime utcDatatime  = dataTime.withOffsetSameInstant(ZoneOffset.UTC);
        return dataTime.format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss"));
    }

}


