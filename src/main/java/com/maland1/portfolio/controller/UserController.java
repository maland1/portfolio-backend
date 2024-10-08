package com.maland1.portfolio.controller;

import com.maland1.portfolio.dto.UserDTO;
import com.maland1.portfolio.exception.UserNotFoundException;
import com.maland1.portfolio.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController
{
    private UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream().map(UserDTO::new).toList();
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable("userId") Long id) throws UserNotFoundException {
        return new UserDTO(userService.getUserById(id));
    }


}
