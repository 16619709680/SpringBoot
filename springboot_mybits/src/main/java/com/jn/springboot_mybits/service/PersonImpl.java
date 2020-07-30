package com.jn.springboot_mybits.service;

import com.jn.springboot_mybits.dao.PersonDao;
import com.jn.springboot_mybits.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonImpl {

    @Autowired
    PersonDao personDao;

    public List<Person> queryPerson() {

        return personDao.queryPerson();

    }

    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }
}
