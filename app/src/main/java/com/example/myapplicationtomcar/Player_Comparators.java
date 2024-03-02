package com.example.myapplicationtomcar;

import static java.lang.Integer.parseInt;

import java.util.Comparator;

public class Player_Comparators {
    private static Comparator<Player> scoreComparator = new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            int score1 = p1.getPlayerScore();
            int score2 = p2.getPlayerScore();
            return score2 - score1;
        }
    };

    public static Comparator<Player> getComparedByScore(){
        return scoreComparator;
    }
}
