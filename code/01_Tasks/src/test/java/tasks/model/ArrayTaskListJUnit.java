package tasks.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class ArrayTaskListJUnit {

    private Task[] tasks;
    private ArrayTaskList arrayTaskList;

    @BeforeEach
    void setUp(){
        tasks = new Task[2];
        arrayTaskList = new ArrayTaskList();
        try {
            tasks[0] = new Task("Task1",Task.getDateFormat().parse("2023-02-12 10:10"));
            tasks[1] = new Task("Task2",Task.getDateFormat().parse("2024-02-12 10:10"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test1(){
        try{
            arrayTaskList.add(tasks[0]);
            arrayTaskList.add(tasks[1]);
            assert(arrayTaskList.getAll().size() == 2);
        }catch (Exception e){
            e.printStackTrace();
            assert(false);
        }
    }

    @Test
    void test2(){
        try{
            arrayTaskList.add(tasks[0]);
            arrayTaskList.add(tasks[1]);
            assert(arrayTaskList.getAll().contains(new Task("Task1",Task.getDateFormat().parse("2023-02-12 10:10"))));
        }catch (Exception e){
            e.printStackTrace();
            assert(false);
        }
    }
}
