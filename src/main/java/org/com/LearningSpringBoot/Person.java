package org.com.LearningSpringBoot;


//
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    @NonNull
    private String name;
    @NonNull
    private Integer id;
//    public Person(Person person) {
//    }
//    public Person(String name, Integer id) {
//        this.name = name;
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", id=" + id +
//                '}';
//    }
}
