package com.crud.tasks.service;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTest {

    @InjectMocks
    TrelloService trelloService;

    @Mock
    TrelloClient trelloClient;

    @Test
    public void shouldFetchTrelloBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        Mockito.when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtos);
        //When
        List<TrelloBoardDto> trelloBoardDtos1 = trelloService.fetchTrelloBoards();
        //Then
        Assert.assertEquals(0, trelloBoardDtos1.size());
    }

    @Test
    public void shouldCreateTrelloCard() {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        Mockito.when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtos);
        //When
        List<TrelloBoardDto> trelloBoardDtos1 = trelloService.fetchTrelloBoards();
        //Then
        Assert.assertEquals(0, trelloBoardDtos1.size());
    }
}
