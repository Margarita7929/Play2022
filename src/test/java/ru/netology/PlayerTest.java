package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlayerTest {

    Player player1 = new Player(1, "Niko", 4);
    Player player2 = new Player(2, "Sonya", 6);
    Player player3 = new Player(3, "Ola", 11);
    Player player4 = new Player(4, "Sunny", 4);
    Player player5 = new Player(5, "Alex", 1);

    Game game = new Game();

    @Test
    public void ifStrengthIdentical() {
        game.registrationOfPlayer(player1);
        game.registrationOfPlayer(player4);
        int expected = 0;

        int actual = game.round("Niko", "Sunny");

        assertEquals(expected, actual);

    }

    @Test
    public void ifFirstPlayerWinner() {
        game.registrationOfPlayer(player2);
        game.registrationOfPlayer(player5);
        int expected = 1;

        int actual = game.round("Sonya", "Alex");

        assertEquals(expected, actual);

    }

    @Test
    public void ifSecondPlayerWinner() {
        game.registrationOfPlayer(player2);
        game.registrationOfPlayer(player3);
        int expected = 2;

        int actual = game.round("Sonya", "Ola");

        assertEquals(expected, actual);

    }

    @Test
    public void ifSecondPlayerNorRegistered() {
        game.registrationOfPlayer(player4);

        int expected = 1;


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Sunny", "Alex");
        });

    }

    @Test
    public void ifFirstPlayerNorRegistered() {
        game.registrationOfPlayer(player3);

        int expected = 2;

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Niko", "Ola");
        });


    }
}
