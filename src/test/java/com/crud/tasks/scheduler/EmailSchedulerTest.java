package com.crud.tasks.scheduler;

import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void shouldSendInformationEmail() {

    }
}
