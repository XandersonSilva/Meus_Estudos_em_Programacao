package com.example.persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.CallableStatement;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import java.time.format.DateTimeFormatter;

import com.example.persistence.entity.ContactEntity;
import com.example.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import lombok.var;

import java.util.ArrayList;
import java.util.List;

import static java.util.TimeZone.LONG;

public class EmployeeParamDAO {
    public void insert(final EmployeeEntity entity){
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO employees (nome, salary, birthday) values (?, ?, ?);"
            )){
                
                statement.setString(1, entity.getNome());
                statement.setBigDecimal(2, entity.getSalary());
                statement.setTimestamp(3,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(ZoneOffset.UTC).toLocalDateTime())
                );
                statement.executeUpdate();
                if(statement instanceof StatementImpl impl){
                    entity.setId(impl.getLastInsertID());
                }
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }

    public void insertWithProcedure(final EmployeeEntity entity){
        try (
            Connection connection = ConnectionUtil.getConnection();
            CallableStatement statement = connection.prepareCall(
                "call prc_insert_employee(?, ?, ?, ?);"
            )){
                statement.registerOutParameter(1, LONG);
                statement.setString(2, entity.getNome());
                statement.setBigDecimal(3, entity.getSalary());
                statement.setTimestamp(4,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(ZoneOffset.UTC).toLocalDateTime())
                );

                statement.execute();
                entity.setId(statement.getLong(1));
                
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }

    public void update(final EmployeeEntity entity){
    try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE employees set nome = ?, salary = ?, birthday = ? WHERE id = ?;")){
                
                statement.setString(1, entity.getNome());
                statement.setBigDecimal(2, entity.getSalary());
                statement.setTimestamp(3,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(ZoneOffset.UTC).toLocalDateTime()));
                statement.setLong(4, entity.getId());

                statement.executeUpdate();

                System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());
                if(statement instanceof StatementImpl impl){
                    entity.setId(impl.getLastInsertID());
                }
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }

    public void delete(final long id){
try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM employees WHERE id=?;")){

                statement.setLong(1, id);
                statement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public List<EmployeeEntity> findAll(){
        List<EmployeeEntity> entities = new ArrayList<>();
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees ORDER BY nome")){
                

                statement.executeQuery();
                ResultSet resultSet = statement.getResultSet();

                while (resultSet.next()) {
                    EmployeeEntity entity = new EmployeeEntity();
                    entity.setId(resultSet.getLong("id"));
                    entity.setNome(resultSet.getString("nome"));
                    entity.setSalary(resultSet.getBigDecimal("salary"));
                    Instant birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                    entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, ZoneOffset.UTC));

                    entities.add(entity);
                }
               
        } catch (Exception e) {
            // TODO: handle exception
        }
        return entities;
    }

    public EmployeeEntity findByID(final long id){
        EmployeeEntity entity = new EmployeeEntity();
        String sql = "SELECT * FROM employees WHERE id=?;";
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
                
                statement.setLong(1, id);
                statement.executeQuery();
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

    public void insert(final List<EmployeeEntity> entities){
        try (Connection connection = ConnectionUtil.getConnection()){
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO employees (nome, salary, birthday) values (?, ?, ?);")){
                    
                        connection.setAutoCommit(false);
                        for (EmployeeEntity entity : entities) {
                            statement.setString(1, entity.getNome());
                            statement.setBigDecimal(2, entity.getSalary());
                            statement.setTimestamp(3,
                                Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(ZoneOffset.UTC).toLocalDateTime()));
                            statement.addBatch();
                        }
                        statement.executeBatch();
                        connection.commit();
                }catch (Exception e) {
                    connection.rollback();
                    e.printStackTrace();
            }
        }catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
    }


    public EmployeeEntity findContactById(long id){
        String sql = " SELECT e.id e_id,"
		            +"    e.nome,"
		            +"    e.salary,"
		            +"    e.birthday,"
		            +"    c.id c_id,"
		            +"    c.description,"
		            +"    c.type,"
		            +"    c.employee_id "
		            +" FROM employees e INNER JOIN contacts c "
		            +" ON c.employee_id = e.id"
		            +" WHERE e.id = ?;";
        EmployeeEntity entity = new EmployeeEntity();
        try (
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
                
                statement.setLong(1, id);
                statement.executeQuery();
                ResultSet resultSet = statement.getResultSet();
                if (resultSet.next()) {
                    
                    entity.setId(resultSet.getLong("e_id"));
                    entity.setNome(resultSet.getString("nome"));
                    entity.setSalary(resultSet.getBigDecimal("salary"));
                    Instant birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                    entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, ZoneOffset.UTC));
                    entity.setContacts(new ArrayList<>());
                    try {
                        do {
                            ContactEntity contact = new ContactEntity();
                            
                            contact.setId(resultSet.getLong("c_id"));
                            contact.setType(resultSet.getString("type"));
                            contact.setDescription(resultSet.getString("description"));
                            
                            entity.getContacts().add(contact);
                        } while(resultSet.next());
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    
                }

               
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
        return entity;
    }

    

}
