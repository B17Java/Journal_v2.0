package com.journal.repository;

import com.journal.model.Teacher;

public interface TeacherRepository {
    boolean save(Teacher teacher);

    Teacher findId(String id);

    String findAll();

    String findByFirstNameOrLastName(String string);

    boolean updateById(String id, String firstName, String lastName);

    boolean deleteById(String id);

}
