package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class TaskMapperTest {

    private TaskMapper taskMapper = new TaskMapper();

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test title", "Test content");
        //When
        long id = taskMapper.mapToTask(taskDto).getId();
        String title = taskMapper.mapToTask(taskDto).getTitle();
        String content = taskMapper.mapToTask(taskDto).getContent();
        //Then
        assertEquals(1, id);
        assertEquals("Test title", title);
        assertEquals("Test content", content);
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "Test title", "Test content");
        //When
        long id = taskMapper.mapToTaskDto(task).getId();
        String title = taskMapper.mapToTaskDto(task).getTitle();
        String content = taskMapper.mapToTaskDto(task).getContent();
        //Then
        assertEquals(1, id);
        assertEquals("Test title", title);
        assertEquals("Test content", content);
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "Test 1", "Test 2"));
        tasks.add(new Task(2L, "Test 2", "Test 3"));
        //When
        List<TaskDto> tasksDto = taskMapper.mapToTaskDtoList(tasks);
        //Then
        assertThat(tasksDto).extracting("id", "title", "content")
                            .contains(tuple(1L, "Test 1", "Test 2"),
                                      tuple(2L, "Test 2", "Test 3"));
    }

}