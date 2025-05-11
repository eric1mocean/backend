package project.example.project;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

    @RestController
    @RequestMapping("/tasks")
    public class TaskController {
        private final TaskService service;

        public TaskController(TaskService service) {
            this.service = service;
        }

        @PostMapping
        public Task createTask(@RequestBody Task task) {
            return service.save(task);
        }

        @GetMapping
        public List<Task> getAllTasks() {
            return service.findAll();
        }

        @PutMapping("/{id}")
        public Task updateTask(@PathVariable String id, @RequestBody Task task) {
            Task taskFromDB=service.getById(id);
            taskFromDB.setStatus(task.getStatus());
            return service.save(taskFromDB);
        }
    }

