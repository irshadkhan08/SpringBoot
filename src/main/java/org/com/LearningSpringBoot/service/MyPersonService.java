package org.com.LearningSpringBoot.service;


import org.com.LearningSpringBoot.CustomException;
import org.com.LearningSpringBoot.model.MyAuthor;
import org.com.LearningSpringBoot.model.MyPerson;
import org.com.LearningSpringBoot.repository.AuthorJpaRepository;
import org.com.LearningSpringBoot.repository.PersonJpaRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;


@Service
public class MyPersonService {
    @Autowired
    private PersonJpaRepository personJpaRepository;

    @Autowired
    private AuthorJpaRepository authorJpaRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional(rollbackOn = {CustomException.class})
    public MyPerson saveMyPerson(MyPerson person) throws CustomException {
//        person.setId(12);
//      return personJpaRepository.save(person);

        MyPerson person1 = personJpaRepository.save(person);

        Session session = (Session) em.getDelegate();
        MyPerson myPerson2 = session.get(MyPerson.class,  person.getId());

        if(person.getAge()==31){
            throw new CustomException("this is not allowed");
        }
        return person1;

    }
    public MyAuthor saveMyAuthor(MyAuthor author){
       return authorJpaRepository.save(author);
    }
}

