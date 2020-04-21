package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTestSuite {

    @InjectMocks
    TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        //Given
        Task task = new Task(1L, "test", "test");
        TaskDto taskDto = new TaskDto(1L, "test", "test");
        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);
        //Then
        Assert.assertTrue(new ReflectionEquals(task).matches(mappedTask));
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        Task task = new Task(1L, "test", "test");
        TaskDto taskDto = new TaskDto(1L, "test", "test");
        //When
        TaskDto mappedTask = taskMapper.mapToTaskDto(task);
        //Then
        Assert.assertTrue(new ReflectionEquals(taskDto).matches(mappedTask));
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        Task task = new Task(1L, "test", "test");
        TaskDto taskDto = new TaskDto(1L, "test", "test");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(taskDto);
        //When
        List<TaskDto> mappedTasks = taskMapper.mapToTaskDtoList(taskList);
        //Then
        Assert.assertTrue(new ReflectionEquals(taskDtoList).matches(mappedTasks));
    }
}
