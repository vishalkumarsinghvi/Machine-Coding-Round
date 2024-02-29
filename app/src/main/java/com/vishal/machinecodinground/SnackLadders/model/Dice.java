package com.vishal.machinecodinground.SnackLadders.model;

import java.util.Random;

public class Dice {
    final int numberOfDice;
    final Random random;

    public Dice(int numberOfDice, Random random) {
        this.numberOfDice = numberOfDice;
        this.random = random;
    }

    public int rollDice() {
        int result = 0;
        for (int i = 0; i < numberOfDice; i++) {
            result += random.nextInt(6) + 1;
        }
        return result;
    }
}
