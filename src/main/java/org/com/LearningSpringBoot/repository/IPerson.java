package org.com.LearningSpringBoot.repository;

import org.com.LearningSpringBoot.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPerson {
    List<Person> getAllPerson();
    Person addPersonWithPreparedStatement(Person person);
    Person addPerson(Person person);
    int updatePerson(String name,int id);
}
