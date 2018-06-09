package com.journal.service.impl;

import com.journal.exception.DataAlreadyExistsException;
import com.journal.exception.IncorrectInputException;
import com.journal.exception.NoSuchDataException;
import com.journal.model.Teacher;
import com.journal.repository.TeacherRepository;
import com.journal.repository.impl.TeacherRepositoryFile;
import com.journal.service.TeacherService;
import com.journal.validator.Validador;

public class TeacherServiceImpl implements TeacherService {

    TeacherRepository teacherRepository = new TeacherRepositoryFile(); //new TeacherRepositoryMap();

    @Override
    public boolean save(String firstName, String lastName) throws IncorrectInputException, DataAlreadyExistsException {
        Validador.validateText(firstName);
        Validador.validateText(lastName);

        if (!teacherRepository.save(new Teacher.Builder().setFirstName(firstName).setLastName(lastName).build())) {
            throw new DataAlreadyExistsException("Such data already exists");
        }
        return true;
    }

    @Override
    public String findId(String id) throws IncorrectInputException, NoSuchDataException {
        Validador.validateNumber(id);

        Teacher teacher = teacherRepository.findId(id);
        if (teacher == null) {
            throw new NoSuchDataException("There is no such data");
        }
        return teacher.toString();
    }

    @Override
    public String findAll() throws NoSuchDataException {
        String string = teacherRepository.findAll();
        if (string == null)
            throw new NoSuchDataException("There is no such data");
        return string;
    }

    @Override
    public String findByFirstNameOrLastName(String name) throws IncorrectInputException, NoSuchDataException {
        Validador.validateText(name);

        String string = teacherRepository.findByFirstNameOrLastName(name);
        if (string == null)
            throw new NoSuchDataException("There is no such data");
        return string;
    }

    @Override
    public boolean updateById(String id, String firstName, String lastName) throws IncorrectInputException, NoSuchDataException {
        Validador.validateNumber(id);
        Validador.validateText(firstName);
        Validador.validateText(lastName);

        if (!teacherRepository.updateById(id, firstName, lastName)) {
            throw new NoSuchDataException("There is no such data");
        }
        return true;
    }

    @Override
    public boolean deleteById(String id) throws IncorrectInputException, NoSuchDataException {
        Validador.validateNumber(id);

        if (!teacherRepository.deleteById(id)) {
            throw new NoSuchDataException("There is no such data");
        }
        return true;
    }
}
