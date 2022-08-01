package ru.netology;

import java.util.ArrayList;


public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void registrationOfPlayer(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player p1 = null;
        Player p2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                p1 = player;
            }
            if (player.getName().equals(playerName2)) {
                p2 = player;
            }
        }
        if (p1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не найден");
        }
        if (p2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не найден");
        }
        if (p1.getStrength() == p2.getStrength()) {
            return 0;
        }
        if (p1.getStrength() > p2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}