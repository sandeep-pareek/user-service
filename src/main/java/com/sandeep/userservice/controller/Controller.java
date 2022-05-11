package com.sandeep.userservice.controller;

import com.sandeep.userservice.entity.User;
import com.sandeep.userservice.service.UserService;
import com.sandeep.userservice.valueobject.ResponceTempleteVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class Controller {
    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        log.info("save user inside controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findByUserId(@PathVariable("id") Long userId) {
        return userService.findByuserId(userId);
    }

    @GetMapping("/userid/{id}")
    public ResponceTempleteVO getUserWithDepartment(@PathVariable("id") Long userId) {

        return userService.getUserWithDepartment(userId);
    }

}
