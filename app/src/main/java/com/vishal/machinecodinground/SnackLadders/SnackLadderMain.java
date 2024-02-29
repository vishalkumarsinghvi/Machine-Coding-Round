package com.vishal.machinecodinground.SnackLadders;

import com.vishal.machinecodinground.SnackLadders.model.GameEntities;
import com.vishal.machinecodinground.SnackLadders.model.Player;
import com.vishal.machinecodinground.SnackLadders.service.PlaySnackLadderService;

import java.util.Scanner;

//output
/*
https://workat.tech/machine-coding/practice/snake-and-ladder-problem-zgtac9lxwntg
9
62 5
33 6
49 9
88 16
41 20
56 53
98 64
93 73
95 75
8
2 37
27 46
10 32
51 68
61 79
65 84
71 91
81 100
2
Gaurav
Sagar
 */

public class SnackLadderMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameEntities gameEntities = GameEntities.getInstance();
        int noOfSnacks = sc.nextInt();
        while (noOfSnacks > 0) {
            int startPosition = sc.nextInt();
            int endPosition = sc.nextInt();
            gameEntities.addSnacks(startPosition, endPosition);
            noOfSnacks--;
        }
        int noOfLadders = sc.nextInt();
        while (noOfLadders > 0) {
            int startPosition = sc.nextInt();
            int endPosition = sc.nextInt();
            gameEntities.addLadders(startPosition, endPosition);
            noOfLadders--;
        }
        int noOfPlayers = sc.nextInt();
        int index = 1;
        while (noOfPlayers > 0) {
            String name = sc.next();
            gameEntities.addPlayer(new Player(index++, name, 0));
            noOfPlayers--;
        }
        PlaySnackLadderService playSnackLadderService = new PlaySnackLadderService(100, gameEntities);
        playSnackLadderService.startGame();
    }
}

