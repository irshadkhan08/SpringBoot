package org.com.LearningSpringBoot.repository;

import org.com.LearningSpringBoot.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class PersonRepo {
//    @Autowired
    private Connection connection;//field injection
    public PersonRepo(Connection connection) {//constructor injection
        this.connection = connection;
        createTablePerson();
    }
    public Person addPersonWithPreparedStatement(Person person){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement  = connection.prepareStatement("insert into Person(name,id) values(?,?);");
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
    private static Logger logger = LoggerFactory.getLogger("TestController.class");
    public List<Person> getAllPerson(){
        List<Person>list = new ArrayList<>();
//        Connection connection=null;
        Statement statement = null;

        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "user");
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select *from Person");
            while(resultSet.next()){
                Person person = new Person(resultSet.getString("name"),resultSet.getInt("id"));

                list.add(person);
            }
        }
        catch (Exception e){
             throw new RuntimeException();
        }
        finally {
            try {
                if(connection!=null) {
                    statement.close();
                }
            }
            catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
         return list;


    }
    public Person addPerson(Person person) {
//        Connection connection = null;
        Statement statement = null;


//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","user","user");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            boolean res = statement.execute("insert into Person(name,id) VALUES('"+person.getName()+"',"+person.getId()+");");
            logger.info("this is connection {}"+res);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            try {
                if(connection!=null) {
                    statement.close();
                }
            }
            catch (SQLException e){
                throw new RuntimeException(e);
            }
            return person;
    }
    public int updatePerson(String name,int id){
        int res = 0;
        PreparedStatement ps = null;
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement("update Person set name=? where id=?");
            ps.setString(1,name);
            ps.setInt(2,id);
           res =  ps.executeUpdate();
           connection.commit();
           connection.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public void createTablePerson(){
//        Connection connection = null;
        Statement statement = null;

//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","user","user");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            statement.execute("create table if not exists Person(name varchar(30), id int)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if(connection!=null) {
                statement.close();
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
