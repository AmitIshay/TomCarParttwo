package com.example.myapplicationtomcar;

import android.location.Location;

public interface PlayersListClickCallback {
    void itemClicked(Player player, int position, Location location);
    void zoomOnRecord(Player player);
}
