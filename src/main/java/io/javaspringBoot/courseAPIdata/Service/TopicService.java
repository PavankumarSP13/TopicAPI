package io.javaspringBoot.courseAPIdata.Service;

import io.javaspringBoot.courseAPIdata.Model.ResponseTopic;
import io.javaspringBoot.courseAPIdata.Model.TopicDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public interface TopicService {

    ResponseTopic<List<TopicDTO>> getAllTopics();

    ResponseTopic<TopicDTO> getTopic(int id);

    ResponseTopic<TopicDTO> addTopic(TopicDTO topicDTO) throws FileNotFoundException;

    ResponseTopic<TopicDTO> updatetopic(int id, TopicDTO topicDTO);

    ResponseTopic<TopicDTO> deleteTopic(int id);

    ResponseTopic<TopicDTO> updatePartialTopic( int id, String name);
}
