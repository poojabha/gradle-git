package example.gradle.controller;

import example.gradle.model.Topic;
import example.gradle.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "/topics")
@RestController
public class TopicController {
    @Autowired
    TopicRepository topicRepository;
    @GetMapping
    public List<Topic> getall()
    {
        return topicRepository.findAll();
    }
    @PostMapping(path ="/Load")
    public Optional<Topic> load(@RequestBody final Topic topic)
    {
        topicRepository.save(topic);
        return topicRepository.findById(topic.getId());
    }
}
