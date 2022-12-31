package com.andrey.redis.demo.controller;

import com.andrey.redis.demo.dao.PersonDao;
import com.andrey.redis.demo.entity.Person;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class DemoController {

    private final PersonDao personDao;

    public DemoController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public List<Person> getAll() {
        return personDao.findAll();
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personDao.save(person);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return personDao.delete(id);
    }

    @GetMapping("/{id}")
    public Person findPerson(@PathVariable int id) {
        return personDao.findById(id);
    }
}
