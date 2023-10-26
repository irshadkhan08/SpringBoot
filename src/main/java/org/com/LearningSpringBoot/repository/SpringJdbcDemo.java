package org.com.LearningSpringBoot.repository;

import org.com.LearningSpringBoot.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SpringJdbcDemo implements IPerson{
    @Autowired
   private JdbcTemplate jdbcTemplate;
    @Override
    public List<Person> getAllPerson() {
        return jdbcTemplate.query("select *from Person", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Person(rs.getString("name"),rs.getInt("id"));
            }
        });
    }
    @Override
    public Person addPersonWithPreparedStatement(Person person){
          jdbcTemplate.execute("insert into Person(name,id) values(?,?);", new PreparedStatementCallback<Boolean>() {
              @Override
              public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                  ps.setString(1,person.getName());
                  ps.setInt(2,person.getId());
                  return ps.execute();
              }
          });

        return person;
    }
    @Override
    public Person addPerson(Person person) {
        return null;
    }
    @Override
    public int updatePerson(String name, int id) {
        return 0;
    }
}
