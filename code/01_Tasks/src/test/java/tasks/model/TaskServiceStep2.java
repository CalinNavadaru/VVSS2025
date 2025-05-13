package tasks.model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.services.TasksService;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TaskServiceStep2 {
    private ArrayTaskList taskList;
    private TasksService service;

    private Task mockTask;

    @BeforeEach
    void setUp() {
        taskList = new ArrayTaskList();
        service = new TasksService(taskList);

        mockTask = mock(Task.class);
    }

    @Test
    void test1() {
        taskList.add(mockTask);
        ObservableList<Task> result = service.getObservableList();

        assertEquals(1, result.size());
        assertSame(taskList.getTask(0), result.getFirst());
    }

    @Test
    void test2() {
        Task task1 = mock(Task.class);
        Task task2 = mock(Task.class);
        Date now = new Date();
        Date later = new Date(now.getTime() + 100000);
        taskList.add(task1);
        taskList.add(task2);
        Iterable<Task> result = service.filterTasks(now, later);

        assertNotNull(result);
    }
}
