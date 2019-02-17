package com.github.felipearomani.springjavatestsexample.services;

import com.github.felipearomani.springjavatestsexample.AbstractIntegrationTest;
import com.github.felipearomani.springjavatestsexample.entities.IncomingTask;
import com.github.felipearomani.springjavatestsexample.entities.Task;
import com.github.felipearomani.springjavatestsexample.exceptions.DuplicatedTaskException;
import com.github.felipearomani.springjavatestsexample.exceptions.NoTitleException;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddTaskServiceImplTest extends AbstractIntegrationTest {

    @Autowired
    private AddTaskServiceImpl addTaskService;

    @Before
    public void setup() {}

    @Test
    public void testMustCreateNewTaskWithRightStatusAndCode() {


        //given
        final String title = "My New Task";
        final String description = "This is a hard new task!";

        IncomingTask myNewTask = IncomingTask
                .builder()
                .title(title)
                .description(description)
                .build();

        //do
        Task task = addTaskService.add(myNewTask);

        //then
        assertThat(task.getId(), Matchers.instanceOf(Long.class));
        assertThat(task.getCode(), Matchers.instanceOf(String.class));
        assertThat(task.getTitle(), Matchers.equalTo(title));
        assertThat(task.getDescription(), Matchers.equalTo(description));
        assertThat(task.getStatus(), Matchers.equalTo(Task.Status.NEW));

        // check if task code is an UUID
        UUID uuid = UUID.fromString(task.getCode());
    }

    @Test(expected = NoTitleException.class)
    public void testMustThrowNoTitleException_whenTitleIsEmpty() {
        //given
        IncomingTask incomingTask = IncomingTask.builder()
                .description("This is a task without title! An error must occur!")
                .build();

        //then
        addTaskService.add(incomingTask);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMustThrowIllegalArgumentException_whenIncomingTaskIsNull() {
        //then
        addTaskService.add(null);
    }

    @Test(expected = DuplicatedTaskException.class)
    public void testMustThrowDuplicatedTaskException_whenSaveTaskWithSameTitleAndStatusNewOrInProgress() {

        //Given
        IncomingTask task1 = IncomingTask.builder()
                .title("My repeated task")
                .description("This is a amazing task!")
                .build();

        IncomingTask task2 = IncomingTask.builder()
                .title("My repeated task")
                .description("This is a amazing task!")
                .build();

        //do
        addTaskService.add(task1);
        addTaskService.add(task2);
    }

}