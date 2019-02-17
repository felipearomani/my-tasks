package com.github.felipearomani.springjavatestsexample.services;

import com.github.felipearomani.springjavatestsexample.entities.IncomingTask;
import com.github.felipearomani.springjavatestsexample.entities.Task;

public interface AddTaskService {
    Task add(IncomingTask incomingTask) throws IllegalArgumentException;
}
