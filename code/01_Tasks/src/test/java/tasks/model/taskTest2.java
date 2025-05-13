package tasks.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class taskTest2 {
    private Task task;

    @BeforeEach
    void setUp() {
        try {
            task = new Task("new task", Task.getDateFormat().parse("2023-02-12 10:10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTaskCreation() throws ParseException {
        assert Objects.equals(task.getTitle(), "new task");
        System.out.println(task.getFormattedDateStart());
        System.out.println(Task.getDateFormat().format(Task.getDateFormat().parse("2023-02-12 10:10")));
        assert task.getFormattedDateStart().equals(Task.getDateFormat().format(Task.getDateFormat().parse("2023-02-12 10:10")));
    }

    @Test
    void test1() {
        try {
            task.setTitle("Mers la facultate");
            task.setTime(new Date(1743080400), new Date(1743087600), 3);
            task.setActive(true);
            assertEquals("Mers la facultate", task.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2() {
        try {
            task.setTitle("Mers la facultate");
            task.setTime(new Date(-133164000), new Date(813520800), 3);
            task.setActive(true);
            assert(false);
        } catch (Exception e) {
            e.printStackTrace();
            assert(true);
        }
    }
}
