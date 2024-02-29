package com.vishal.machinecodinground.SnackLadders.model;

public class Player {
    private final int id;
    private final String name;
    private int currentPosition;

    public Player(int id, String name, int currentPosition) {
        this.id = id;
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

}
