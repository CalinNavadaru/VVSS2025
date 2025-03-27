package tasks.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

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
    void testECP1() {
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
    void testECP2() {
        try {
            task.setTitle("Mers la facultate");
            task.setTime(new Date(-133164000), new Date(813520800), 3);
            task.setActive(true);
            assertEquals(1, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testECP3() {
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
    void testECP4() {
        try {
            task.setTitle("Mers la facultate");
            task.setTime(new Date(1743080400), new Date(1743087600), -12);
            task.setActive(true);
            assertEquals("Mers la facultate", task.getTitle());
            assertEquals(1, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testBVA1() {
        try {
            task.setTitle("Mers la facultate");
            task.setTime(new Date(1743080400), new Date(1743087600), 0);
            task.setActive(true);
            assertEquals("Mers la facultate", task.getTitle());
            assertEquals(1, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testBVA2() {
        try {
            task.setTitle("Mers la facultate");
            task.setTime(new Date(1743080400), new Date(1743087600), 1);
            task.setActive(true);
            assertEquals("Mers la facultate", task.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testBVA3() {
        try {
            task.setTitle("Mers la facultate");
            task.setTime(new Date(1743080400), new Date(1743087600), 2);
            task.setActive(true);
            assertEquals("Mers la facultate", task.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testBVA4() {
        try {
            task.setTitle("Mers la facultate");
            task.setTime(new Date(-7201), new Date(-7140), 1);
            task.setActive(true);
            assertEquals("Mers la facultate", task.getTitle());
            assertEquals(1, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }@Test
    void testBVA5() {
        try {
            task.setTitle("Mers la facultate");
            task.setTime(new Date(-7200), new Date(-7140), 1);
            task.setActive(true);
            assertEquals("Mers la facultate", task.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
    }
}