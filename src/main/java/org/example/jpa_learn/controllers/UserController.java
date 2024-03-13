package org.example.jpa_learn.controllers;

import org.example.jpa_learn.models.User;
import org.example.jpa_learn.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intern-vnpt")
public class UserController {

    private UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    add new user
    @PostMapping(path = "/add")
    public String addNewUser(@RequestParam String name, @RequestParam String email) {
        userRepository.save(new User(name, email));
        System.out.println("Add new user: " + name + " - " + email + " successfully");
        return "Saved";
    }

    //    delete user
    @DeleteMapping(path = "/delete")
    public String deleteUser(@RequestParam Integer id) {
        if (!userRepository.existsById(id)) {
            System.out.println("User with id: " + id + " not found");
            return "Not found";
        }
        userRepository.deleteById(id);
        System.out.println("Delete user with id: " + id + " successfully");
        return "Deleted";
    }

    //    update user
    @PutMapping(path = "/update")
    public String updateUser(@RequestParam Integer id, @RequestParam String name, @RequestParam String email) {
        if (!userRepository.existsById(id)) {
            System.out.println("User with id: " + id + " not found");
            return "Not found";
        }
        User user = userRepository.findById(id).get();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        System.out.println("Update user with id: " + id + " successfully");
        return "Updated";
    }

    //    find user
    @GetMapping(path = "/find")
    public User findUser(@RequestParam Integer id) {
        if (!userRepository.existsById(id)) {
            System.out.println("User with id: " + id + " not found");
            return null;
        }
        return userRepository.findById(id).get();
    }


    //    get all users and sort by name or email (default is name)
    @GetMapping(path = "/all")
    public @ResponseBody List<User> getAllUser(@RequestParam(required = false, defaultValue = "name") String sort) {
        if (sort.equals("email")) {
            return userRepository.findAll(Sort.sort(User.class).by(User::getEmail));
        }
        return userRepository.findAll(Sort.sort(User.class).by(User::getName));
    }

}
