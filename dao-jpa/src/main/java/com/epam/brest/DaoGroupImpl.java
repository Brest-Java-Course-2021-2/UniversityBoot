package com.epam.brest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ComponentScan("com.epam.brest")
public class DaoGroupImpl implements DaoGroupApi {

    private final Logger logger = LogManager.getLogger(DaoGroupImpl.class);

    @Autowired
    private GroupJpaRepository groupRepository;

    @Override
    public List<String> getAllGroupsNames() {
        logger.info("GET ALL GROUPE NAMES {}");
        return groupRepository.getAllGroupsNames();
    }

    @Override
    public List<Group> getAllGroups() {
        logger.info("GET ALL GROUPES  {}");
        return groupRepository.getAllGroups();
    }

    @Override
    public String deleteGroupByName(String groupName) {
        logger.info("DELETE GROUPE BY the NAME {}");
        return groupRepository.deleteGroupByGroupName(groupName);
    }

    @Override
    public Group insertNewGroup(String newNameOfGroup) {
        logger.info("CREATE NEW GROUPE {}");
        return groupRepository.insertNewGroup(newNameOfGroup);
    }

    @Override
    public Group getGroupByName(String nameGroup) {
        logger.info("GET GROUPE BY NAME {}");
        return groupRepository.getGroupeByGroupName(nameGroup);
    }

    @Override
    public Group updateGroup(String newName, String oldName) {
        logger.info("UPDATE GROUPE.NAME BY NEW NAME {}");
        return groupRepository.updateGroupByGroupName(newName, oldName);
    }
}
