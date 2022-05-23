package com.epam.brest.kafkaweb.consumer;

import com.epam.brest.Group;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Component
@EnableJpaRepositories(basePackages = "com.epam.brest")
public class GroupConsumerServiceWeb {

    private static final Logger logger = LoggerFactory.getLogger(GroupConsumerServiceWeb.class);
    @Autowired
    private final ConsumerFactory<String, String> stringKafkaTemplate;
    @Autowired
    private final ConsumerFactory <String, Group> groupKafkaTemplate;
    @Autowired
    private final ConsumerFactory<String, List<Group>> listGroupKafkaTemplate;

    public List<Group> groups = new ArrayList<>();

    public Boolean isListChanged = false;
    public GroupConsumerServiceWeb(
              ConsumerFactory<String, String> stringKafkaTemplate
            , ConsumerFactory<String, Group> groupKafkaTemplate
            , ConsumerFactory<String, List<Group>> listGroupKafkaTemplate) {

        this.stringKafkaTemplate = stringKafkaTemplate;
        this.groupKafkaTemplate = groupKafkaTemplate;
        this.listGroupKafkaTemplate = listGroupKafkaTemplate;
        }

    @KafkaListener(topics = "sendallgroups", groupId = "listgroup")
    public void listenGroupFoo(String message) {
        logger.info("Received Message in string : " + message);
        try{
            /*ObjectMapper mapper = new ObjectMapper();
            List <Group> groupsJson = (List<Group>) mapper.readValue(message, List.class);*/
            ObjectMapper mapper = new ObjectMapper();
            groups = mapper.readValue(message, new TypeReference<List<Group>>() {
            });


            /*Gson gson = new Gson();
            groups = (List<Group>) gson.fromJson(message, List.class);*/
            isListChanged = true;
            logger.info("Received Message in ALL Groups : " + groups.toString());
        }catch (Exception ex){
            throw new SerializationException(ex);
        }

    }

    @KafkaListener(topics = "newgroupcreated", groupId = "group")
    public void newGroupFoo(String group) {
        System.out.println("Received Message in string : " + group);
        try{
            ObjectMapper mapper = new ObjectMapper();
            Group updatedGroup = mapper.readValue(group, Group.class);
            System.out.println("Received Message in greeting : " + updatedGroup.toString());
        }catch (Exception ex){

            throw new SerializationException(ex);
        }
    }

    @KafkaListener(topics = "updatedgroup", groupId = "group")
    public void updateGroupFoo(String group) {
        System.out.println("Received Message  tu Update Group in string : " + group);
        try{
            ObjectMapper mapper = new ObjectMapper();
            Group updatedGroup = mapper.readValue(group, Group.class);
            System.out.println("Received Message in greeting : " + updatedGroup.toString());
        }catch (Exception ex){

            throw new SerializationException(ex);
        }
    }


}
