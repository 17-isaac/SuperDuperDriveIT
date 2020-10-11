package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NotesMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UsersMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class HomeController {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private NotesMapper notesMapper;

    @GetMapping("/all")
    public List<Users> getAll() {

        List<Users> users = usersMapper.findAll();
        System.err.println("*****************" + users);
        return usersMapper.findAll();
    }

    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable Integer id) {
        Users user = usersMapper.findOne(id);
        user.setNotes(notesMapper.findNoteByUserId(id));
        return user;
    }
}
