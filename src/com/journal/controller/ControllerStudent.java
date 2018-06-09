package com.journal.controller;

import com.journal.exception.DataAlreadyExistsException;
import com.journal.exception.IncorrectInputException;
import com.journal.exception.NoSuchDataException;
import com.journal.service.StudentService;
import com.journal.service.impl.StudentServiceImpl;

public class ControllerStudent {

    private StudentService studentService = new StudentServiceImpl();

    public String save(String firstName, String lastName) {
        try {
            studentService.save(firstName, lastName);
            return "The record is successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (DataAlreadyExistsException e) {
            return e.getMessage();
        }
    }

    public String findId(String id) {
        try {
            return studentService.findId(id);
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String findAll() {
        try {
            return studentService.findAll();
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String findByFirstNameOrLastName(String name) {
        try {
            return studentService.findByFirstNameOrLastName(name);
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String updateById(String id, String firstName, String lastName) {
        try {
            studentService.updateById(id, firstName, lastName);
            return "Update successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String deleteById(String id) {
        try {
            studentService.deleteById(id);
            return "Delete successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

//    public String saveStudentToGroup(){
//        System.out.print("Input student id : ");
//        String idStudent = scanner.nextLine();
//        System.out.print("Input group id : ");
//        String idGroup = scanner.nextLine();
//        try {
//            if(groupStudentService.saveStudentToGroup(idStudent, idGroup)){
//                return "is Ok";
//            } else {
//                return  "id does not exist";
//            }
//        } catch (IncorrectInputException e) {
//            return e.toString();
//        } catch (NullPointerException e){
//            return  "NullPointerException";
//        }
//    }

    public String getStudentFromGroup() {
        return null;
    }
}
