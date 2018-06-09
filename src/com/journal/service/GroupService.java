package com.journal.service;

import com.journal.exception.DataAlreadyExistsException;
import com.journal.exception.IncorrectInputException;
import com.journal.exception.NoSuchDataException;

public interface GroupService {
    boolean save(String group) throws IncorrectInputException, DataAlreadyExistsException;

    String findId(String id) throws IncorrectInputException, NoSuchDataException;

    String findAll() throws IncorrectInputException, NoSuchDataException;

    String findByFirstNameOrLastName(String group) throws IncorrectInputException, NoSuchDataException;

    boolean updateById(String id, String group) throws IncorrectInputException, NoSuchDataException;

    boolean deleteById(String id) throws IncorrectInputException, NoSuchDataException;
}
