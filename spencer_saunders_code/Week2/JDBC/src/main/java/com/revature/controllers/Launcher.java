package com.revature.controllers;

import com.revature.beans.Teacher;
import com.revature.services.TeacherService;

import java.util.List;

public class Launcher {
    static TeacherService teacherService = new TeacherService();

    public static void main(String[] args) {
//        Teacher teacher = teacherService.getTeacher(1);

//        List<Teacher> teachers = teacherService.getByName("August", "Duet");
//
//        for(Teacher t : teachers){
//            System.out.println(t);
//        }
//        System.out.println(teacher);
//        teacher.setFavoriteQuote("Straight to my hips.");
//
//        Teacher testTeacher = teacherService.getTeacher(7);
//        teacherService.delete(testTeacher);


        Teacher newTeacher = new Teacher();
        newTeacher.setFirstname("mehrab");
        newTeacher.setLastname("Rahman");
        newTeacher.setFavoriteQuote("abandon all delusions of control.");
        teacherService.saveTeacher(newTeacher);
        System.out.println(newTeacher);
    }
}
