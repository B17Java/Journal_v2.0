package com.journal.service;

import com.journal.exception.DataAlreadyExistsException;
import com.journal.exception.IncorrectInputException;
import com.journal.exception.NoSuchDataException;

public interface StudentService {
    boolean save(String firstName, String lastName) throws IncorrectInputException, DataAlreadyExistsException;

    String findId(String id) throws IncorrectInputException, NoSuchDataException;

    String findAll() throws IncorrectInputException, NoSuchDataException;

    String findByFirstNameOrLastName(String name) throws IncorrectInputException, NoSuchDataException;

    boolean updateById(String id, String firstName, String lastName) throws IncorrectInputException, NoSuchDataException;

    boolean deleteById(String id) throws IncorrectInputException, NoSuchDataException;
}
