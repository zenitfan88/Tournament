package ru.netology.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    protected Map<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int findByName(String name) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int round(String name1, String name2) {
        int result = 0;
        Player player1 = players.get(name1);
        Player player2 = players.get(name2);
        if (player1 == null) {
            throw new NotFoundException("Игрок " + name1 + " не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotFoundException("Игрок " + name2 + " не зарегистрирован");
        }

        int playerStr1 = player1.getStrength();
        int playerStr2 = player2.getStrength();

        if (playerStr1 > playerStr2) {
            result = 1;
        }
        if (playerStr1 < playerStr2) {
            result = 2;
        }
        return result;
    }
}

