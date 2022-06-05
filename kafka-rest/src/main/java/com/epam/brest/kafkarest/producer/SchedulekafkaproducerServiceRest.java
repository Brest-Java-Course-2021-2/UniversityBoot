package com.epam.brest.kafkarest.producer;

import com.epam.brest.LectorsSchedule;
import com.epam.brest.StudentsSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulekafkaproducerServiceRest {

    @Autowired
    private KafkaTemplate<String, String> stringGroupKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, List<LectorsSchedule>> listLectorsScheduleKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, List<StudentsSchedule>> listStudentsScheduleKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, List<List<StudentsSchedule>>> listAllStudentsScheduleKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, List<List<LectorsSchedule>>> listAllLectorsScheduleKafkaTemplate;


    private String sendscheduleforallstudents = "sendscheduleforallstudents";

    private String sendscheduleforalllectors = "sendscheduleforalllectors";

    private String sendscheduleforlector = "sendscheduleforlector";

    private String sendscheduleforgroup = "sendscheduleforgroup";


}
