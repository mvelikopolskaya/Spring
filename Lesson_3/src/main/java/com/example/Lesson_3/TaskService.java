package com.example.Lesson_3;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service

public class TaskService {

    private final List<Task> tasks = new ArrayList<>();


    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTask(UUID id) {
       return tasks.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public void deleteTask(UUID id) {
        tasks.removeIf(t -> t.getId().equals(id));
    }

    public Task updateTask(UUID id, Task task) {
        Task requiredTask = getTask(id);
        if (requiredTask != null) {
            if(task.getName() != null && !task.getName().isEmpty()){
                requiredTask.setName(task.getName());
            }
            if(task.getDescription() != null && !task.getDescription().isEmpty()){
                requiredTask.setDescription(task.getDescription());
            }
            if(task.getStatus() != null){
                requiredTask.setStatus(task.getStatus());
            }
        }
        return requiredTask;
    }
}
