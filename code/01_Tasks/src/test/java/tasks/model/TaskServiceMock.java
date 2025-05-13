package tasks.model;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.services.TasksService;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaskServiceMock {
    private ArrayTaskList mockTaskList;
    private TasksService service;

    private Task mockTask;

    @BeforeEach
    void setUp() {
        mockTaskList = mock(ArrayTaskList.class);
        service = new TasksService(mockTaskList);

        mockTask = mock(Task.class);
    }

    @Test
    void test1() {
        List<Task> taskList = Collections.singletonList(mockTask);
        when(mockTaskList.getAll()).thenReturn(taskList);

        ObservableList<Task> result = service.getObservableList();

        assertEquals(1, result.size());
        assertSame(mockTask, result.getFirst());
    }

    @Test
    void test2() {
        Task task1 = mock(Task.class);
        Task task2 = mock(Task.class);
        Date now = new Date();
        Date later = new Date(now.getTime() + 100000);

        ObservableList<Task> mockList = javafx.collections.FXCollections.observableArrayList(task1, task2);
        when(mockTaskList.getAll()).thenReturn(mockList);

        Iterable<Task> result = service.filterTasks(now, later);

        assertNotNull(result);
    }
}
