package com.jn.springboot_mybits.controller;


import com.jn.springboot_mybits.entity.Person;
import com.jn.springboot_mybits.service.PersonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybitsController {

        @Autowired
        PersonImpl personImpl;


        @RequestMapping("query")
        public  String  query(){
            List<Person>  personList = personImpl.queryPerson();
            for (Person p: personList) {
                System.out.println(p);
            }
            return "queryOk";
        }


        @RequestMapping("update/{name}")
        public  String  update(@PathVariable("name") String name){
                Person person = new Person();
                person.setName(name);
                person.setSex("女");
                personImpl.updatePerson(person);

            return "updateOk";
        }


}
