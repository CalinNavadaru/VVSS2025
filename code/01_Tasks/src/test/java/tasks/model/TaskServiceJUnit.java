package tasks.model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.services.TasksService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceJUnit {

    private ArrayTaskList taskList;
    private TasksService service;

    private Task task;

    @BeforeEach
    void setUp() {
        taskList = new ArrayTaskList();
        service = new TasksService(taskList);
        task = new Task("Task 1", new Date());
    }

    @Test
    void test1() {
        taskList.add(task);

        ObservableList<Task> result = service.getObservableList();

        assertEquals(1, result.size());
        assertSame(task, result.getFirst());
    }

    @Test
    void test2() {
        Date now = new Date();
        Date later = new Date(now.getTime() + 100000);

        Task task1 = new Task("Task 1", now);
        Task task2 = new Task("Task 2", later);

        taskList.add(task1);
        taskList.add(task2);

        Iterable<Task> result = service.filterTasks(now, later);

        assertNotNull(result);
    }
}
