package com.journal.repository;

import com.journal.model.Group;

public interface GroupRepository {

    boolean save(Group group);

    Group findId(String id);

    String findAll();

    String findByFirstNameOrLastName(String groupName);

    boolean updateById(String id, String groupName);

    boolean deleteById(String id);
}
