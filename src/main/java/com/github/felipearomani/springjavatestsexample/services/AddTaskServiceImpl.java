package com.github.felipearomani.springjavatestsexample.services;

import com.github.felipearomani.springjavatestsexample.entities.IncomingTask;
import com.github.felipearomani.springjavatestsexample.entities.Task;
import com.github.felipearomani.springjavatestsexample.exceptions.NoTitleException;
import com.github.felipearomani.springjavatestsexample.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;

@Service
public final class AddTaskServiceImpl implements AddTaskService {

    private TaskRepository taskRepository;

    @Autowired
    public AddTaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task add(IncomingTask incomingTask) throws IllegalArgumentException, NoTitleException {

        AssertIncomingTask.isNull(incomingTask);
        AssertIncomingTask.titleIsNotNullOrEmpty(incomingTask);

        Task task = Task.builder()
                .title(incomingTask.getTitle())
                .description(incomingTask.getDescription())
                .code(UUID.randomUUID().toString())
                .status(Task.Status.NEW)
                .build();

        return taskRepository.save(task);
    }
}

class AssertIncomingTask {

    private final static String ERROR_NO_TITLE = "Title can't be null on service!";
    private final static String ERROR_ARGUMENT_NOT_NULL = "Incoming task can't be null!";

    static void titleIsNotNullOrEmpty(IncomingTask incomingTask) throws NoTitleException {
        if (incomingTask.getTitle() == null || incomingTask.getTitle().length() == 0) {
            throw new NoTitleException(ERROR_NO_TITLE);
        }
    }

    static void isNull(IncomingTask incomingTask) throws IllegalArgumentException {
        Assert.notNull(incomingTask, ERROR_ARGUMENT_NOT_NULL);
    }
}
