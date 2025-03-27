package tasks.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.model.TaskList;

import java.io.*;
import java.nio.file.Files;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskIOTest {

    TaskList mockData;
    File testFile;
    FileOutputStream out;

    @BeforeEach
    void setUp() throws IOException {
        mockData = new ArrayTaskList();
        testFile = File.createTempFile("test_tasks", ".txt");
        testFile.deleteOnExit();
        out = new FileOutputStream(testFile);
    }

    @AfterEach
    void destroy() throws IOException {
        out.close();
    }

    @Test
    void test_ECP_1() throws IOException {
        TaskList rezultat = new ArrayTaskList();
        TaskIO.write(mockData, out);
        System.out.println(Files.readString(testFile.toPath()));
        TaskIO.read(rezultat, new FileInputStream(testFile));
        System.out.println(rezultat);
        assertEquals(0, rezultat.size());
    }

    @Test
    void write_one_element_file_existing() throws IOException {
        TaskList rezultat = new ArrayTaskList();
        Task task = new Task("Mers la piata", new Date(1742921005));
        mockData.add(task);
        TaskIO.write(mockData, out);
        TaskIO.read(rezultat, new FileInputStream((testFile)));
        assertEquals(1, rezultat.size());
        assertEquals(rezultat.getTask(0), mockData.getTask(0));
    }
    @Test
    void write_one_element_file_not_existing() throws IOException {
        TaskList rezultat = new ArrayTaskList();
        Task task = new Task("Mers la piata", new Date(1742921005));
        mockData.add(task);
        mockData = null;
        try {

            TaskIO.write(mockData, out);
            assertEquals(0, 1, "A admis tasklist null!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}