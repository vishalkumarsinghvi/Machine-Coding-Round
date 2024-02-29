package com.vishal.machinecodinground.model;

import java.util.HashMap;

public class GameEntities {
    final private HashMap<Integer, Integer> snacks = new HashMap<>();
    final private HashMap<Integer, Integer> ladders = new HashMap<>();
    final private HashMap<Integer, Player> player = new HashMap<>();

    private static final GameEntities INSTANCE = new GameEntities();

    private GameEntities() {

    }

    public static GameEntities getInstance() {
        return INSTANCE;
    }

    public void addSnacks(int startPosition, int endPosition) {
        snacks.put(startPosition, endPosition);
    }

    public void addLadders(int startPosition, int endPosition) {
        ladders.put(startPosition, endPosition);
    }

    public void addPlayer(Player player) {
        this.player.put(player.getId(), player);
    }

    public HashMap<Integer, Integer> getSnacks() {
        return snacks;
    }

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public HashMap<Integer, Player> getPlayer() {
        return player;
    }
}
