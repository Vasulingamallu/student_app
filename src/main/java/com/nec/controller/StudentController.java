package com.nec.controller;

import com.nec.entity.StudentEntity;
import com.nec.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/save")
    public String saveStudent(@RequestParam int rollNumber,
                              @RequestParam String name) {
        StudentEntity s = new StudentEntity();
        s.setRollNumber(rollNumber);
        s.setName(name);
        repo.save(s);
        return "redirect:/show";
    }

    @GetMapping("/show")
    public String showStudents(Model model) {
        model.addAttribute("students", repo.findAll());
        return "show";
    }
}
