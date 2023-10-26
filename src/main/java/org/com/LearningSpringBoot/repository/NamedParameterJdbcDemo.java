package org.com.LearningSpringBoot.repository;

import org.com.LearningSpringBoot.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NamedParameterJdbcDemo implements IPerson{
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public List<Person> getAllPerson() {
        return null;
    }
    @Override
    public Person addPersonWithPreparedStatement(Person person) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name",person.getName());
        mapSqlParameterSource.addValue("id",person.getId());
        namedParameterJdbcTemplate.execute("insert into Person(name,id) VALUES(:name,:id)", mapSqlParameterSource, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
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
