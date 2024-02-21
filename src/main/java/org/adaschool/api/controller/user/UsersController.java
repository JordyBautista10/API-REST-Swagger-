package org.adaschool.api.controller.user;

import org.adaschool.api.exception.UserNotFoundException;
import org.adaschool.api.repository.user.User;
import org.adaschool.api.repository.user.UserDto;
import org.adaschool.api.service.user.UsersService;
import org.adaschool.api.service.user.UsersServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/users/")
public class UsersController {

    private final UsersService usersService;

    public UsersController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto user) {
        //TODO implement this method
        URI createdUserUri = URI.create("");
        return ResponseEntity.created(createdUserUri).body(usersService.save(new User(user)));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        //TODO implement this method
        return ResponseEntity.ok(null);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        //TODO implement this method
        try {
            return ResponseEntity.ok(usersService.findById(id).get());
        }catch (Exception e) {
            throw new UserNotFoundException(id);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody UserDto user) {
        //TODO implement this method
        usersService.save(usersService.findById(id).get().update(user));

        return ResponseEntity.ok(null);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser() {
        //TODO implement this method
        return ResponseEntity.ok().build();
    }
}
