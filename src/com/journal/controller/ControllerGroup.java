package com.journal.controller;

import com.journal.exception.DataAlreadyExistsException;
import com.journal.exception.IncorrectInputException;
import com.journal.exception.NoSuchDataException;
import com.journal.service.GroupService;
import com.journal.service.impl.GroupServiceImpl;

public class ControllerGroup {

    private GroupService groupService = new GroupServiceImpl();

    public String save(String groupName) {
        try {
            groupService.save(groupName);
            return "The record is successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (DataAlreadyExistsException e) {
            return e.getMessage();
        }
    }

    public String findId(String id) {
        try {
            return groupService.findId(id);
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String findAll() {
        try {
            return groupService.findAll();
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String findByFirstNameOrLastName(String name) {
        try {
            return groupService.findByFirstNameOrLastName(name);
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String updateById(String id, String groupName) {
        try {
            groupService.updateById(id, groupName);
            return "Update successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }

    public String deleteById(String id) {
        try {
            groupService.deleteById(id);
            return "Delete successful";
        } catch (IncorrectInputException e) {
            return e.getMessage();
        } catch (NoSuchDataException e) {
            return e.getMessage();
        }
    }
}
