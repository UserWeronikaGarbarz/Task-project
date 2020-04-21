package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Mock
    private TrelloClient trelloClient;

    @Test //1
    public void shouldMapToBoards() {
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("test", "test", new ArrayList<>());
        TrelloBoard trelloBoard = new TrelloBoard("test", "test", new ArrayList<>());
        List<TrelloBoardDto> trelloBoardDtoList = trelloClient.getTrelloBoards();
        trelloBoardDtoList.add(trelloBoardDto);
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);
        //When
        List<TrelloBoard> boards = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        Assert.assertTrue(new ReflectionEquals(boards).matches(trelloBoardList));
    }

    @Test //2
    public void shouldMapToBoardsDto() {
        //Given
        TrelloBoard trelloBoard = new TrelloBoard("test", "test", new ArrayList<>());
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("test", "test", new ArrayList<>());
        List<TrelloBoardDto> trelloBoardDtoList = trelloClient.getTrelloBoards();
        trelloBoardDtoList.add(trelloBoardDto);
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);
        //When
        List<TrelloBoardDto> boards = trelloMapper.mapToBoardsDto(trelloBoardList);
        //Then
        Assert.assertTrue(new ReflectionEquals(boards).matches(trelloBoardList));
    }

    @Test //3
    public void shouldMapToList() {
        //Given
        TrelloList trelloList = new TrelloList("test", "test", false);
        TrelloListDto trelloListDto = new TrelloListDto("test", "test", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(trelloListDto);
        //When
        List<TrelloList> lists = trelloMapper.mapToList(trelloListsDto);
        //Then
        Assert.assertTrue(new ReflectionEquals(lists).matches(trelloLists));
    }

    @Test //4
    public void shouldMapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList("test", "test", false);
        TrelloListDto trelloListDto = new TrelloListDto("test", "test", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(trelloListDto);
        //When
        List<TrelloListDto> lists = trelloMapper.mapToListDto(trelloLists);
        //Then
        Assert.assertTrue(new ReflectionEquals(lists).matches(trelloListsDto));
    }

    @Test //5
    public void shouldMapToCard() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test", "test", "test", "test");
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test", "test", "test");
        //When
        TrelloCard card = trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertTrue(new ReflectionEquals(card).matches(trelloCard));
    }

    @Test //6
    public void shouldMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test", "test", "test", "test");
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test", "test", "test");
        //When
        TrelloCardDto card = trelloMapper.mapToCardDto(trelloCard);
        //Then
        Assert.assertTrue(new ReflectionEquals(card).matches(trelloCardDto));
    }
}