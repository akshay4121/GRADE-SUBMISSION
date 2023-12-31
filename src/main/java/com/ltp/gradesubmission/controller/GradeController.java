package com.ltp.gradesubmission.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.service.GradeService;

@Controller
public class GradeController {

    GradeService gradeService = new GradeService();

    //GET request handler for the form
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("grade", gradeService.getGradeById(id));
        return "form";
    }

    // POST request handler for form submission
    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) return "form";
        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }

    //Delete request handler for grade deletion
    @GetMapping("/delete/")
    public String deleteGrade(@RequestParam String id){
        gradeService.deleteGrade(id);
        return "redirect:/grades";
    }

    // GET request handler for displaying all grades
    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }


}