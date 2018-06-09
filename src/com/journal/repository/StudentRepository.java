package com.journal.repository;

import com.journal.model.Student;

public interface StudentRepository {

    boolean save(Student teacher);

    Student findId(String id);

    String findAll();

    String findByFirstNameOrLastName(String string);

    boolean updateById(String id, String firstName, String lastName);

    boolean deleteById(String id);
}
