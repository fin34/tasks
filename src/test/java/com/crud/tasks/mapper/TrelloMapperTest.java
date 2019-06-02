package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrelloMapperTest {
    @Test
    public void testMapToBoardsDtoAndMapToBoards() {
        //Given
        TrelloMapper trelloMapper = new TrelloMapper();
        TrelloList listOne = new TrelloList("1", "Test one", true);
        TrelloList listTwo = new TrelloList("2", "Test two", true);
        TrelloList listThree = new TrelloList("3", "Test three", true);
        TrelloList listFour = new TrelloList("4", "Test four", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(listOne);
        trelloLists.add(listTwo);
        List<TrelloList> trelloLists1 = new ArrayList<>();
        trelloLists1.add(listThree);
        trelloLists1.add(listFour);
        TrelloBoard boardOne = new TrelloBoard("1", "Board one", trelloLists);
        TrelloBoard boardTwo = new TrelloBoard("2", "Board two", trelloLists1);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(boardOne);
        trelloBoards.add(boardTwo);
        //When
        List<TrelloBoardDto> resultMapToBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);
        List<TrelloBoard> resultMapToBoard = trelloMapper.mapToBoards(resultMapToBoardsDto);
        //Then
        assertEquals(2, resultMapToBoardsDto.size());
        assertEquals(2, resultMapToBoard.size());
    }
}