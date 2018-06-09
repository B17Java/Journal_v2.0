package com.journal.service.impl;

import com.journal.exception.DataAlreadyExistsException;
import com.journal.exception.IncorrectInputException;
import com.journal.exception.NoSuchDataException;
import com.journal.model.Student;
import com.journal.repository.StudentRepository;
import com.journal.repository.impl.StudentRepositoryFile;
import com.journal.service.StudentService;
import com.journal.validator.Validador;

public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository = new StudentRepositoryFile();

    @Override
    public boolean save(String firstName, String lastName) throws IncorrectInputException, DataAlreadyExistsException {
        Validador.validateText(firstName);
        Validador.validateText(lastName);

        if (!studentRepository.save(new Student.Builder().setFirstName(firstName).setLastName(lastName).build())) {
            throw new DataAlreadyExistsException("Such data already exists");
        }
        return true;
    }

    @Override
    public String findId(String id) throws IncorrectInputException, NoSuchDataException {
        Validador.validateNumber(id);

        Student student = studentRepository.findId(id);
        if (student == null) {
            throw new NoSuchDataException("There is no such data");
        }
        return student.toString();
    }

    @Override
    public String findAll() throws NoSuchDataException {
        String string = studentRepository.findAll();
        if (string == null)
            throw new NoSuchDataException("There is no such data");
        return string;
    }

    @Override
    public String findByFirstNameOrLastName(String name) throws IncorrectInputException, NoSuchDataException {
        Validador.validateText(name);

        String string = studentRepository.findByFirstNameOrLastName(name);
        if (string == null)
            throw new NoSuchDataException("There is no such data");
        return string;
    }

    @Override
    public boolean updateById(String id, String firstName, String lastName) throws IncorrectInputException, NoSuchDataException {
        Validador.validateNumber(id);
        Validador.validateText(firstName);
        Validador.validateText(lastName);

        if (!studentRepository.updateById(id, firstName, lastName)) {
            throw new NoSuchDataException("There is no such data");
        }
        return true;
    }

    @Override
    public boolean deleteById(String id) throws IncorrectInputException, NoSuchDataException {
        Validador.validateNumber(id);

        if (!studentRepository.deleteById(id)) {
            throw new NoSuchDataException("There is no such data");
        }
        return true;
    }
}
