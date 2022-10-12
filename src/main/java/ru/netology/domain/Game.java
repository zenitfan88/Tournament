package ru.netology.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    protected List<Player> players = new ArrayList<>();


    public void register(Player player) {
        players.add(player);
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
        int playerName1 = findByName(name1);
        int playerName2 = findByName(name2);

        if (playerName1 == -1) {
            throw new NotFoundException("Игрок " + name1 + " не зарегистрирован");
        }
        if (playerName2 == -1) {
            throw new NotFoundException("Игрок " + name2 + " не зарегистрирован");
        }

        int playerStr1 = players.get(playerName1).getStrength();
        int playerStr2 = players.get(playerName2).getStrength();

        if (playerStr1 > playerStr2) {
            result = 1;
        }
        if (playerStr1 < playerStr2) {
            result = 2;
        }
        return result;
    }
}

