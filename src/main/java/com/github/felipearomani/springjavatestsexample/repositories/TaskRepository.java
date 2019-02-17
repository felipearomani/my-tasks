package com.github.felipearomani.springjavatestsexample.repositories;

import com.github.felipearomani.springjavatestsexample.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    Task save(Task task);
}
