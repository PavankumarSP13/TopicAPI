package io.javaspringBoot.courseAPIdata.Controller;

import io.javaspringBoot.courseAPIdata.Model.ResponseTopic;
//import io.javaspringBoot.courseAPIdata.Model.TopicDAO;
import io.javaspringBoot.courseAPIdata.Service.TopicService;
import io.javaspringBoot.courseAPIdata.Service.impl.TopicServiceImpl;
import io.javaspringBoot.courseAPIdata.Model.TopicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired //dependency injection
    private TopicService topicService;



    @GetMapping("/topics") //will be converted to json by spring mvc
    public ResponseTopic<List<TopicDTO>> getAllTopics()
    {
            return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public ResponseTopic<TopicDTO> getTopic(@PathVariable int id){
        return topicService.getTopic(id);
    }

    @PostMapping ("/topics")
    public ResponseTopic<TopicDTO> addTopic(@RequestBody TopicDTO topicDTO) throws IOException//pick this instance from request payload
    {
//        final String Path = "C:/Users/pavankumar.sp/Desktop/";
//        String name = topicDTO.getName();
//        File fp = new File(Path + name);
//        fp.createNewFile();
//        FileWriter fwrite = new FileWriter(Path + name);
//        fwrite.write(topicDTO.getDescription());
//
//        fwrite.close();
        return topicService.addTopic(topicDTO);
    }

    @PutMapping( "/topics/{id}")
    public ResponseTopic<TopicDTO> addTopic(@RequestBody TopicDTO topicDTO, @PathVariable int id)//pick this instance from request payload
    {
        return topicService.updatetopic(id, topicDTO);
    }

    @DeleteMapping("/topics/{id}")
    public ResponseTopic<TopicDTO> deleteTopic(@PathVariable int id){
         return topicService.deleteTopic(id);
    }

    @PatchMapping("/topics/{id}/{name}")
    public ResponseTopic<TopicDTO> updatePartialTopic( @PathVariable int id , @PathVariable String name){
        return topicService.updatePartialTopic(id,name);

    }
}
