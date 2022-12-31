package com.andrey.redis.demo.dao;

import com.andrey.redis.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    private static final String HASH_KEY = "Person";
    private final RedisTemplate redisTemplate;

    @Autowired
    public PersonDaoImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Person save(Person person) {
        redisTemplate.opsForHash().put(HASH_KEY, person.getId(), person);
        return person;
    }

    @Override
    public List<Person> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    @Override
    public String delete(int id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "Person {%d} was deleted!".formatted(id);
    }

    @Override
    public Person findById(int id) {
        return ((Person) redisTemplate.opsForHash().get(HASH_KEY, id));
    }
}
