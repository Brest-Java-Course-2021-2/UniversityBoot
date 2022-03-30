package com.epam.brest;

import com.epam.brest.Group;

import java.util.List;

public interface GroupServiceApi {

    List<String> getAllGroupNamesService();

    List<Group> getAllGroupsService();

    Integer deletegroupByIdService(Integer idGroup);

    Group createNewGroupService(String newName);

    Group getGroupByGroupNameService(String name);

    Group updateGroupNameService(Group group);

    Group getGroupById (Integer idGroup);

}
