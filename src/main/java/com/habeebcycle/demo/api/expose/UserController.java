package com.habeebcycle.demo.api.expose;

import com.habeebcycle.demo.api.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/rest/user")
@Log4j2
public class UserController {

    private static final String KEY = "KEY_USER";

    private final ReactiveRedisOperations<String, User> redisOperations;
    private final ReactiveHashOperations<String, String, User> hashOperations;

    @Autowired
    public UserController(ReactiveRedisOperations<String, User> redisOperations) {
        this.redisOperations = redisOperations;
        this.hashOperations = redisOperations.opsForHash();
    }

    @PostMapping("/add")
    public Mono<Boolean> saveUser(@RequestParam(value = "message", defaultValue = "EMPTY_MESSAGE") String message) {
        String id = String.valueOf(new Random().nextInt());
        User user = new User(id, new Date(), message);
        log.info(user);
        return hashOperations.put(KEY, user.getId().toString(), user);
    }

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable(value = "id", required = true) String id) {
       return hashOperations.get(KEY, id);
    }

}