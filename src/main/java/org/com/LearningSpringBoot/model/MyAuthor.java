package org.com.LearningSpringBoot.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MyAuthor {
    @Id
    @GeneratedValue(strategy =GenerationType.TABLE)
    private Integer id;

    @Column(length = 30)
    private String Name;
}
