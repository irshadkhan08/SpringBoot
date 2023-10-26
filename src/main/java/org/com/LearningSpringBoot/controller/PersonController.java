package org.com.LearningSpringBoot.controller;

import org.com.LearningSpringBoot.CustomException;
import org.com.LearningSpringBoot.Person;
import org.com.LearningSpringBoot.model.MyAuthor;
import org.com.LearningSpringBoot.model.MyPerson;
import org.com.LearningSpringBoot.repository.AuthorJpaRepository;
import org.com.LearningSpringBoot.repository.PersonJpaRepository;
import org.com.LearningSpringBoot.service.MyPersonService;
import org.com.LearningSpringBoot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private MyPersonService myPersonService;
    @GetMapping("/getPersons")
//    @ResponseBody
    public ResponseEntity<List<Person>> getPersonData(){

        List<Person>list = personService.getPersonData();
        ResponseEntity<List<Person>>responseEntity = new ResponseEntity<>(list,HttpStatus.OK);
        return responseEntity;
    }
   @PostMapping("/addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
    if(person.getId() == null){
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Person p = personService.addPerson(person);
    return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/updatePerson")
    public ResponseEntity<Integer>update( @RequestParam String name,@RequestParam Integer id) {
        if(id==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(personService.updatePerson(name,id),HttpStatus.OK);
    }

//    @PutMapping("/updatePerson")
//    public ResponseEntity<Integer>update( @RequestBody Person person) {
//    if(person.getId()==null){
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//    return new ResponseEntity<>(personService.updatePerson(person.getName(),person.getId()),HttpStatus.OK);
//    }

//@PutMapping("/updatePersons")
//    public ResponseEntity<Integer> updatePerson(@RequestBody Person person) {
//        if(person.getId()==null)
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<>(personService.updatePerson(person.getId(),person.getName()),HttpStatus.OK);
//    }

    @PostMapping("/addMyPerson")
    public MyPerson addMyPerson(@RequestBody MyPerson person) throws CustomException {
        return myPersonService.saveMyPerson(person);
    }

    @PostMapping("/addMyAuthor")
    public MyAuthor addMyAuthor(@RequestBody MyAuthor author){
        return myPersonService.saveMyAuthor(author);
    }

}
