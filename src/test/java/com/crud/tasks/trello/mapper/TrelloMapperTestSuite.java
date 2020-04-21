package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TrelloMapperTestSuite {

    @Test //1
    public void shouldMapToBoards() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("test", "test", new ArrayList<>());
        TrelloBoard trelloBoard = new TrelloBoard("test", "test", new ArrayList<>());
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);
        List<TrelloBoard> expected = new ArrayList<>();
        expected.add(trelloBoard);
        //When
        List<TrelloBoard> result = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        Assert.assertEquals(expected.get(0).getName(), result.get(0).getName());
    }

    @Test //2
    public void shouldMapToBoardsDto() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloBoard trelloBoard = new TrelloBoard("test", "test", new ArrayList<>());
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("test", "test", new ArrayList<>());
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard);
        List<TrelloBoardDto> expected = new ArrayList<>();
        expected.add(trelloBoardDto);
        //When
        List<TrelloBoardDto> result = trelloMapper.mapToBoardsDto(trelloBoardList);
        //Then
        Assert.assertEquals(expected.get(0).getName(), result.get(0).getName());
    }

    @Test //3
    public void shouldMapToList() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloList trelloList = new TrelloList("test", "test", false);
        TrelloListDto trelloListDto = new TrelloListDto("test", "test", false);
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(trelloListDto);
        List<TrelloList> expected = new ArrayList<>();
        expected.add(trelloList);
        //When
        List<TrelloList> result = trelloMapper.mapToList(trelloListsDto);
        //Then
        Assert.assertEquals(expected.get(0).getName(), result.get(0).getName());
    }

    @Test //4
    public void shouldMapToListDto() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloList trelloList = new TrelloList("test", "test", false);
        TrelloListDto trelloListDto = new TrelloListDto("test", "test", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        List<TrelloListDto> expected = new ArrayList<>();
        expected.add(trelloListDto);
        //When
        List<TrelloListDto> result = trelloMapper.mapToListDto(trelloLists);
        //Then
        Assert.assertEquals(expected.get(0).getName(), result.get(0).getName());
    }

    @Test //5
    public void shouldMapToCard() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCard trelloCard = new TrelloCard("test", "test", "test", "test");
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test", "test", "test");
        //When
        TrelloCard card = trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals(card.getName(), trelloCard.getName());
    }

    @Test //6
    public void shouldMapToCardDto() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloCard trelloCard = new TrelloCard("test", "test", "test", "test");
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test", "test", "test");
        //When
        TrelloCardDto card = trelloMapper.mapToCardDto(trelloCard);
        //Then
        Assert.assertEquals(trelloCardDto.getName(), card.getName());
    }
}