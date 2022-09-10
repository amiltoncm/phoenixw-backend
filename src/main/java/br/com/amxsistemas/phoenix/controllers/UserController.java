package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.entities.User;
import br.com.amxsistemas.phoenix.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    User save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") UUID id) {
        userService.delete(id);
    }

    @GetMapping
    List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    User getById(@PathVariable("id") UUID id) {
        return userService.getById(id);
    }

}
