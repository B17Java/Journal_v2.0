package com.journal.controller;

import com.journal.exception.DataAlreadyExistsException;
import com.journal.exception.IncorrectInputException;
import com.journal.exception.NoSuchDataException;
import com.journal.service.TeacherService;
import com.journal.service.impl.TeacherServiceImpl;

public class ControllerTeacher {

    private TeacherService teacherService = new TeacherServiceImpl();

    public String save(String firstName, String lastName) {
        try {
            teacherService.save(firstName, lastName);
            return "The record is successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (DataAlreadyExistsException e) {
            return e.getMessage();
        }
    }

    public String findId(String id) {
        try {
            return teacherService.findId(id);
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String findAll() {
        try {
            return teacherService.findAll();
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String findByFirstNameOrLastName(String name) {
        try {
            return teacherService.findByFirstNameOrLastName(name);
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String updateById(String id, String firstName, String lastName) {
        try {
            teacherService.updateById(id, firstName, lastName);
            return "Update successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String deleteById(String id) {
        try {
            teacherService.deleteById(id);
            return "Delete successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }
}
