package tasks.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ArrayTaskListMock {

    private Task[] tasks;
    private ArrayTaskList arrayTaskList;

    @BeforeEach
    void setUp() {
        tasks = new Task[2];
        arrayTaskList = new ArrayTaskList();
        tasks[0] = mock(Task.class);
        tasks[1] = mock(Task.class);
    }

    @Test
    void test1() {
        arrayTaskList.add(tasks[0]);
        arrayTaskList.add(tasks[1]);
        assertEquals(2, arrayTaskList.getAll().size());

    }

    @Test
    void test2() {
        arrayTaskList.add(tasks[0]);
        arrayTaskList.add(tasks[1]);
        arrayTaskList.remove(tasks[0]);
        assertTrue(arrayTaskList.getAll().contains(tasks[1]));
        assertFalse(arrayTaskList.getAll().contains(tasks[0]));


    }
}
