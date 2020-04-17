package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.CreatedTrelloCard;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;


    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {

//        trelloBoards.stream().filter((x) -> trelloBoards.contains("(.*)name(.*)") && trelloBoards.contains("(.*)id(.*)"))
//                .filter(trelloBoardDto -> trelloBoardDto.getName().matches("Kodilla(.*)"))
//                .forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));

        return trelloClient.getTrelloBoards();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {

        return trelloClient.createNewCard(trelloCardDto);
    }
}