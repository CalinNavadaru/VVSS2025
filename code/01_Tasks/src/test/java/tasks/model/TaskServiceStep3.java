package tasks.model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.services.TasksService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceStep3 {
    private ArrayTaskList taskList;
    private TasksService service;

    private Task mockTask;

    @BeforeEach
    void setUp() {
        taskList = new ArrayTaskList();
        service = new TasksService(taskList);

        mockTask = new Task("TaskMock", new Date());
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
        Date now = new Date();
        Task task1 = new Task("Task1", new Date(), new Date(now.getTime() + 999999999), 2);
        Task task2 = new Task("Task2", new Date(), new Date(now.getTime() + 999999999), 2);
        task1.setActive(true);
        task2.setActive(true);
        Date later = new Date(now.getTime() + 999999999);
        taskList.add(task1);
        taskList.add(task2);
        Iterable<Task> result = service.filterTasks(now, later);
        List<Task> res = new ArrayList<>();
        result.forEach(res::add);

        assertEquals(2, res.size());
        assertEquals(task1, res.getFirst());
    }
}
