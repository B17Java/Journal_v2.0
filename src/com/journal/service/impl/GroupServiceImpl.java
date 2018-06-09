package com.journal.service.impl;

import com.journal.exception.DataAlreadyExistsException;
import com.journal.exception.IncorrectInputException;
import com.journal.exception.NoSuchDataException;
import com.journal.model.Group;
import com.journal.repository.GroupRepository;
import com.journal.repository.impl.GroupRepositoryFile;
import com.journal.service.GroupService;
import com.journal.validator.Validador;

public class GroupServiceImpl implements GroupService {

    GroupRepository groupRepository = new GroupRepositoryFile();

    @Override
    public boolean save(String groupName) throws IncorrectInputException, DataAlreadyExistsException {
        Validador.validateGroup(groupName);

        if (!groupRepository.save(new Group.Builder().setGroup(groupName).build())) {
            throw new DataAlreadyExistsException("Such data already exists");
        }
        return true;
    }

    @Override
    public String findId(String id) throws IncorrectInputException, NoSuchDataException {
        Validador.validateNumber(id);

        Group group = groupRepository.findId(id);
        if (group == null) {
            throw new NoSuchDataException("There is no such data");
        }
        return group.toString();
    }

    @Override
    public String findAll() throws NoSuchDataException {
        String string = groupRepository.findAll();
        if (string == null)
            throw new NoSuchDataException("There is no such data");
        return string;
    }

    @Override
    public String findByFirstNameOrLastName(String name) throws IncorrectInputException, NoSuchDataException {
        Validador.validateGroup(name);

        String string = groupRepository.findByFirstNameOrLastName(name);
        if (string == null)
            throw new NoSuchDataException("There is no such data");
        return string;
    }

    @Override
    public boolean updateById(String id, String groupName) throws IncorrectInputException, NoSuchDataException {
        Validador.validateNumber(id);
        Validador.validateGroup(groupName);

        if (!groupRepository.updateById(id, groupName)) {
            throw new NoSuchDataException("There is no such data");
        }
        return true;
    }

    @Override
    public boolean deleteById(String id) throws IncorrectInputException, NoSuchDataException {
        Validador.validateNumber(id);

        if (!groupRepository.deleteById(id)) {
            throw new NoSuchDataException("There is no such data");
        }
        return true;
    }
}
