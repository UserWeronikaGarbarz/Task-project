package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {

    @InjectMocks
    DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void shouldGetAllTasks() {
        //Given
        List<Task> tasks = new ArrayList<>();
        Task task = new Task();
        Task task1 = new Task();
        tasks.add(task);
        tasks.add(task1);
        Mockito.when(taskRepository.findAll()).thenReturn(tasks);
        //When
        List<Task> taskList = dbService.getAllTasks();
        // Then
        Assert.assertEquals(2, taskList.size());
    }

    @Test
    public void shouldGetTask() {
        //Given
        Task task = new Task(1L, "test", "test");
        Mockito.when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        //When
        Optional<Task> optionalTask = dbService.getTask(1L);
        //Then
        Assert.assertTrue(optionalTask.isPresent());
    }

    @Test
    public void shouldSaveTask() {
        //Given
        Task task = new Task(1L, "test", "test");
        Mockito.when(taskRepository.save(task)).thenReturn(task);
        //When
        Task task1 = dbService.saveTask(task);
        //Then
        Assert.assertEquals(task.getId(), task1.getId());
    }

    @Test
    public void shouldDeleteTask() {
        taskRepository.deleteById(1L);
    }
}
