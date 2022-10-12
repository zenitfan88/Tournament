package ru.netology.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void startUp() {
        manager.register(List.of(player1, player2, player, player3));
    }

    @Test
    void winFirstPlayer() {
        assertEquals(1, manager.round("Max", "Lika"));
    }

    @Test
    void winSecondPlayer() {
        assertEquals(2, manager.round("Max", "Lex"));
    }

    @Test
    void drawPlayer() {
        assertEquals(0, manager.round("Max", "Lexy"));
    }

    @Test
    void playerNotRegister() {
        assertThrows(NotFoundException.class, () -> {
            manager.round("Max", "Mike");
        });

        assertThrows(NotFoundException.class, () -> {
            manager.round("Anna", "Mike");
        });
    }

}
