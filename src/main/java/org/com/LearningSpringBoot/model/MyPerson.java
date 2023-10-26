package org.com.LearningSpringBoot.model;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="personData")//means update the table name MyPerson to personData
public class MyPerson {
    @Id
    @GeneratedValue(strategy =GenerationType. TABLE)
    private Integer id;
    @Column(name = "first_name",length = 30)
    private String fName;

    private String lName;
    @Column(length = 30,unique = true)
    String email;
    Integer age;

    @Transient
    private String country;

}
//    create table person_data (id integer not null,
//   create table person_data (id integer not null auto_increment