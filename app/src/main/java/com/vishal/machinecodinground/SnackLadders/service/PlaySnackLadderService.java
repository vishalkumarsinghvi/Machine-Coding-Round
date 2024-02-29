package com.vishal.machinecodinground.SnackLadders.service;

import com.vishal.machinecodinground.SnackLadders.model.Dice;
import com.vishal.machinecodinground.SnackLadders.model.GameEntities;
import com.vishal.machinecodinground.SnackLadders.model.Player;

import java.util.HashMap;
import java.util.Random;

public class PlaySnackLadderService {
    private final int capacity;
    private final Player player1;
    private final Player player2;
    private boolean isPlayer1Playing = false;
    private final HashMap<Integer, Integer> snacks;
    private final HashMap<Integer, Integer> ladders;
    private final Dice dice;

    public PlaySnackLadderService(int capacity, GameEntities gameEntities) {
        this.capacity = capacity;
        dice = new Dice(1, new Random());
        this.player1 = gameEntities.getPlayer().get(1);
        this.player2 = gameEntities.getPlayer().get(2);
        this.snacks = gameEntities.getSnacks();
        this.ladders = gameEntities.getLadders();
    }

    public void startGame() {
        while (true) {
            Player currentPlayer = isPlayer1Playing ? player2 : player1;
            int currentPosition = currentPlayer.getCurrentPosition();
            int rollDice = dice.rollDice();
            int upcomingPosition = currentPosition + rollDice;
            if (snacks.containsKey(upcomingPosition)) {
                Integer snackEndPosition = snacks.get(upcomingPosition);
                if (snackEndPosition != null) {
                    upcomingPosition = snackEndPosition;
                }
            } else if (ladders.containsKey(upcomingPosition)) {
                Integer ladderEndPosition = ladders.get(upcomingPosition);
                if (ladderEndPosition != null) {
                    upcomingPosition = ladderEndPosition;
                }
            }
            if (isWinnerFound(upcomingPosition, currentPlayer)) break;
            if (upcomingPosition < capacity) {
                updatePlayerPosition(currentPlayer, rollDice, upcomingPosition);
            }
            isPlayer1Playing = !isPlayer1Playing;
        }
    }

    private boolean isWinnerFound(int upcomingPosition, Player player) {
        if (upcomingPosition == capacity) {
            System.out.println(player.getName() + " wins the game");
            return true;
        }
        return false;
    }

    public void updatePlayerPosition(Player player, int rolled, int newPosition) {
        System.out.println(player.getName() + " rolled a " + rolled + " and moved from " + player.getCurrentPosition() + " to " + newPosition);
        player.setCurrentPosition(newPosition);
    }
}
