package com.ltp.gradesubmission.repository;

import java.util.ArrayList;
import java.util.List;

import com.ltp.gradesubmission.Grade;

public class GradeRepository {
    
    private List<Grade> studentGrades = new ArrayList<>();

    // Retrieve grade at index
    public Grade getGrade(int index) {
        return studentGrades.get(index);
    }

    // Add grade to list    
    public void addGrade(Grade grade) {
        studentGrades.add(grade);
    }

    //delete grade from the list
    public void deleteGrade(int index){
        studentGrades.remove(index);
    }

    // Update grade at index
    public void updateGrade(Grade grade, int index) {
        studentGrades.set(index, grade);
    }
    
    // Retrieve all grades
    public List<Grade> getGrades() {
        return studentGrades;
    }

}
