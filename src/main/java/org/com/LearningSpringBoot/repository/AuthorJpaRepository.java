package org.com.LearningSpringBoot.repository;

import org.com.LearningSpringBoot.model.MyAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorJpaRepository extends JpaRepository<MyAuthor,Integer> {

}
