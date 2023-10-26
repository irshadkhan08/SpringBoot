package org.com.LearningSpringBoot.repository;

import org.com.LearningSpringBoot.model.MyPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonJpaRepository extends JpaRepository<MyPerson,Integer> {

}
