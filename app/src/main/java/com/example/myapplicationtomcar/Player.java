package com.example.myapplicationtomcar;

import android.location.Location;

import androidx.annotation.NonNull;

public class Player implements Comparable<Player>{
    String playerName;
    int playerScore;
    private double playerLatitude;
    private double playerLongitude;

    public Player(String playerName, int playerScore, double playerLatitude, double playerLongitude) {
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.playerLatitude = playerLatitude;
        this.playerLongitude = playerLongitude;
    }

    public Player() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public Player setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public Player setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
        return this;
    }

    public double getPlayerLatitude() {
        return playerLatitude;
    }

    public void setPlayerLatitude(double playerLatitude) {
        this.playerLatitude = playerLatitude;
    }

    public double getPlayerLongitude() {
        return playerLongitude;
    }

    public void setPlayerLongitude(double playerLongitude) {
        this.playerLongitude = playerLongitude;
    }
    public Location getLocation() {
        Location playerLocation = new Location(getPlayerName() +"'s Location");
        playerLocation.setLongitude(this.playerLongitude);
        playerLocation.setLatitude(this.playerLatitude);
        return playerLocation;
    }
    public Player setLocation(Location location) {
        this.playerLatitude = location.getLatitude();
        this.playerLongitude = location.getLongitude();
        return this;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerScore=" + playerScore +
                ", playerLatitude=" + playerLatitude +
                ", playerLongitude=" + playerLongitude +
                '}';
    }
    @Override
    public int compareTo(@NonNull Player other) {
        // compare players by score
        int score1 = this.playerScore;
        int score2 = other.playerScore;
        return Integer.compare(score2, score1);
    }
}
