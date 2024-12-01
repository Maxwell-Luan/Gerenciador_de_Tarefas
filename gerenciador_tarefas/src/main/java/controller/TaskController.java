package controller;

import model.Task;
import model.User;
import repository.TaskRepository;
import util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getTasks(@RequestHeader("Authorization") String token) {
        String username = JwtUtil.validateToken(token.substring(7));
        return taskRepository.findByUserUsername(username);
    }

    @PostMapping
    public Task createTask(@RequestHeader("Authorization") String token, @RequestBody Task task) {
        String username = JwtUtil.validateToken(token.substring(7));
        task.setUser(new User());
        task.getUser().setUsername(username);
        return taskRepository.save(task);
    }
}
