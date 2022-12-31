package com.andrey.redis.demo.dao;

import com.andrey.redis.demo.entity.Person;

import java.util.List;

public interface PersonDao {

    Person save(Person person);

    List<Person> findAll();

    String delete(int id);

    Person findById(int id);
}
