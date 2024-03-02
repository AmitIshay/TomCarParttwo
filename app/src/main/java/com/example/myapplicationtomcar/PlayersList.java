package com.example.myapplicationtomcar;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PlayersList {
    @SerializedName("playersListName")
    private String playersListName = DataManager.getPlayersListJsonKey();
    @SerializedName("playersList")
    private ArrayList<Player> playersList = new ArrayList<>();

    public PlayersList setPlayerListName(String name) {
        this.playersListName = name;
        return this;
    }
    public Player getPlayerByPosition(int position) {
        if (position >= 0 && position < playersList.size()) {
            return playersList.get(position);
        }
        return null;
    }

    public int getListSize() {
        return playersList.size();
    }

    public void addPlayer(Player player) {
        if(getListSize() == 10){
            if(player.getPlayerScore() > playersList.get(getListSize()-1).getPlayerScore())
                playersList.remove(getListSize()-1);
        }
        playersList.add(player);
        sortList();
    }
    public void sortList() {
        this.playersList.sort(Player_Comparators.getComparedByScore());
    }
}
