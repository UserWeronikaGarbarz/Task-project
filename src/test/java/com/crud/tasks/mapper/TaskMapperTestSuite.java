package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class TaskMapperTestSuite {

    @Test
    public void shouldMapToTask() {
        //Given
        TaskMapper taskMapper = new TaskMapper();
        Task task = new Task(1L, "test", "test");
        TaskDto taskDto = new TaskDto(1L, "test", "test");
        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);
        //Then
        Assert.assertEquals(task.getTitle(), mappedTask.getTitle());
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        TaskMapper taskMapper = new TaskMapper();
        Task task = new Task(1L, "test", "test");
        TaskDto taskDto = new TaskDto(1L, "test", "test");
        //When
        TaskDto mappedTask = taskMapper.mapToTaskDto(task);
        //Then
        Assert.assertEquals(taskDto.getTitle(), mappedTask.getTitle());
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        TaskMapper taskMapper = new TaskMapper();
        Task task = new Task(1L, "test", "test");
        TaskDto taskDto = new TaskDto(1L, "test", "test");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(taskDto);
        //When
        List<TaskDto> mappedTasks = taskMapper.mapToTaskDtoList(taskList);
        //Then
        Assert.assertEquals(taskList.get(0).getTitle(), mappedTasks.get(0).getTitle());
    }
}
