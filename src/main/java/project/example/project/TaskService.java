package project.example.project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskService extends JpaRepository<Task, String> {



}
