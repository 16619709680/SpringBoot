package com.jn.springboot_mybits.dao;

import com.jn.springboot_mybits.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface PersonDao {
    List<Person> queryPerson();

    void updatePerson(Person person);
}
