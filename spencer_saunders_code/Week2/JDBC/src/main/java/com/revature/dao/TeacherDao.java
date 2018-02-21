package com.revature.dao;

import com.revature.beans.Teacher;

import java.util.List;

public interface TeacherDao {

    public Teacher getById(int id);

    public List<Teacher> getByName(String first_name, String last_name);

    public void newTeacher(Teacher teacher);

    public void update(Teacher teacher);

    public void delete(Teacher teacher);

    }

