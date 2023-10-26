package org.com.LearningSpringBoot.service;

import org.com.LearningSpringBoot.Person;
import org.com.LearningSpringBoot.repository.IPerson;
import org.com.LearningSpringBoot.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.com.LearningSpringBoot.service.PersonService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
 import org.com.LearningSpringBoot.repository.IPerson;

import java.util.List;
@Service
@Repository

public class PersonService {

    // @Autowired
// private PersonRepo personRepo;
//
//  public List<Person>getPersonData(){
//     return personRepo.getAllPerson();
//  }
// public Person addPerson(Person person) {
//      return personRepo.addPerson(person);
// }
// public Person addPersonWithPreparedStatement(Person person)
// {
//      return personRepo.addPersonWithPreparedStatement(person);
// }
//
// public int updatePerson(String name,int id){
//      return personRepo.updatePerson(name,id);
// }
    @Autowired
    @Qualifier("namedParameterJdbcDemo")
    private IPerson iPerson;
    public List<Person>getPersonData(){
        return iPerson.getAllPerson();
    }
    public Person addPerson(Person person) {
        return addPersonWithPreparedStatement(person);
    }
    public Person addPersonWithPreparedStatement(Person person)
    {
        return iPerson.addPersonWithPreparedStatement(person);
    }
    public int updatePerson(String name,int id){
        return iPerson.updatePerson(name,id);
    }
}
