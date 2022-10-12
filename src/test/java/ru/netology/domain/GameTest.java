package ru.netology.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    private Game manager = new Game();
    Player player = new Player(101, "Max", 18);
    Player player1 = new Player(222, "Lex", 183);
    Player player2 = new Player(347, "Lexy", 18);
    Player player3 = new Player(447, "Lika", 7);

    @Test
    void winFirstPlayer() {
        manager.register(player);
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);

        assertEquals(1, manager.round("Max", "Lika"));
    }

    @Test
    void winSecondPlayer() {
        manager.register(player);
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);

        assertEquals(2, manager.round("Max", "Lex"));
    }

    @Test
    void drawPlayer() {
        manager.register(player);
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);

        assertEquals(0, manager.round("Max", "Lexy"));
    }

    @Test
    void playerNotRegister() {
        manager.register(player);
        manager.register(player1);
        manager.register(player2);

        assertThrows(NotFoundException.class, () -> {
            manager.round("Max", "Mike");
        });

        assertThrows(NotFoundException.class, () -> {
            manager.round("Anna", "Mike");
        });
    }

}
