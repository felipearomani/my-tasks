package com.github.felipearomani.springjavatestsexample.services;

import com.github.felipearomani.springjavatestsexample.entities.IncomingTask;
import com.github.felipearomani.springjavatestsexample.entities.Task;
import com.github.felipearomani.springjavatestsexample.exceptions.DuplicatedTaskException;
import com.github.felipearomani.springjavatestsexample.exceptions.NoTitleException;

public interface AddTaskService {
    Task add(IncomingTask incomingTask) throws IllegalArgumentException, NoTitleException, DuplicatedTaskException;
}
