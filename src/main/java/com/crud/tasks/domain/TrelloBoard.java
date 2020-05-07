package com.crud.tasks.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrelloBoard {
    private String name;
    private String id;
    private List<TrelloList> lists;

}
