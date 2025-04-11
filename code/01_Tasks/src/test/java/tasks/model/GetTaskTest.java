package tasks.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetTaskTest {

    private TaskList taskList1;
    private Task task1, task2, task3, task4;

    @BeforeEach
    void setUp() {
        try {
            task1 = new Task("new task", Task.getDateFormat().parse("2024-10-10 10:10"));
            task2 = new Task("new task2", Task.getDateFormat().parse("2024-10-10 10:10"),Task.getDateFormat().parse("2024-10-10 10:11"),2);
            task3 = new Task("new task3", Task.getDateFormat().parse("2024-10-10 10:10"));
            task4 = new Task("new task4", Task.getDateFormat().parse("2023-10-10 10:10"));
            task1.setActive(true);
            task2.setActive(true);
            task3.setActive(true);
            task4.setActive(true);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void F02_TC01() {
        TaskList taskList2 = new LinkedTaskList();
        try {
            var x = taskList2.incoming(Task.getDateFormat().parse("2024-10-10 00:00"), Task.getDateFormat().parse("2024-10-11 00:00"));
            assertEquals(0, x.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void F02_TC02() {
        taskList1 = new ArrayTaskList();
        try {
            var x = taskList1.incoming(Task.getDateFormat().parse("2024-10-10 00:00"), Task.getDateFormat().parse("2024-10-11 00:00"));
            assertEquals(0, x.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void F02_TC03() {
        taskList1 = new ArrayTaskList();
        taskList1.add(task1);
        taskList1.add(task2);
        taskList1.add(task3);
        taskList1.add(task4);
        try {
            taskList1.incoming(Task.getDateFormat().parse("2024-10-10 00:00"), Task.getDateFormat().parse("2024-10-09 00:00"));
            assert(false);
        } catch (Exception e) {
            assert(true);
            e.printStackTrace();
        }
    }

    @Test
    void F02_TC04() {
        taskList1 = new ArrayTaskList();
        taskList1.add(task1);
        taskList1.add(task2);
        taskList1.add(task3);
        taskList1.add(task4);
        assertEquals(4,taskList1.size());
        try {
            var x = taskList1.incoming(Task.getDateFormat().parse("2024-10-10 00:00"), Task.getDateFormat().parse("2024-10-11 00:00"));
            assertEquals (3, x.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void F02_TC05() {
        taskList1 = new ArrayTaskList();
        taskList1.add(task4);
        try {
            var x = taskList1.incoming(Task.getDateFormat().parse("2024-10-10 00:00"), Task.getDateFormat().parse("2024-10-11 00:00"));
            assertEquals (0, x.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
