package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddPlayerTime(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Vasiliy", 3);
        assertEquals(store.getSumPlayedTime(), 3);
    }
    /*Суммирует ли метод addPlayTime значения*/
    @Test
    public void shouldAddPlayerTimeSumm(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Vasiliy", 3);
        store.addPlayTime("Vasiliy", 18);
        assertEquals(store.getSumPlayedTime(), 21);
    }
    /*Тест на самого играющего без игроков */
    @Test
    public void shouldMostPlayerTimeWithoutPlayers(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        assertEquals(store.getMostPlayer(),null);

    }

    /*Тест на самого играющего*/
    @Test
    public void shouldMostPlayerTime(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Vasiliy", 5);
        store.addPlayTime("Genadiy", 2);
        assertEquals(store.getMostPlayer(),"Vasiliy");

    }
    /*Тест на самого играющего при одинкаовых значениях*/
    @Test
    public void shouldMostPlayerTimeSameValues(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Vasiliy", 5);
        store.addPlayTime("Genadiy", 5);
        assertEquals(store.getMostPlayer(),"Vasiliy");

    }
/*Тест на самого играющего при трех значениях*/
    @Test
    public void shouldMostPlayerTimeThree(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Genadiy", 4);
        store.addPlayTime("Vasiliy", 5);
        store.addPlayTime("Genadiy", 2);
        assertEquals(store.getMostPlayer(),"Genadiy");

    }

    /*Ищет самого играющего игрока при отсутствии их*/
    @Test
    public void shouldGetMostPlayerWithNull(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        assertEquals(store.getMostPlayer(), null);
    }


    /*Тест на суммирование метода getSumPlayedTime*/
    @Test
    public void shouldSummPlayerTeime(){
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        store.addPlayTime("Genadiy", 4);
        store.addPlayTime("Vasiliy", 5);
        store.addPlayTime("Genadiy", 2);
        assertEquals(store.getSumPlayedTime(),11);
}}
