package com.example.myapplicationtomcar;

import android.location.Location;

import java.security.PublicKey;
import java.util.ArrayList;

public class DataManager {
    private static final int MAX_NUM_OF_PLAYERS = 10;
    private static final String PLAYERS_LIST_JSON_KEY = "playersList";

    private static final int NUM_OF_Rows = 8;
    public static final int NUM_OF_LANES = 5;
    private static final int lBl_score = R.id.LBL_score;
    private static final int left_button = R.id.left_button;
    private static final int right_button = R.id.right_button;

    private static int[] road_one_rocks = {
            R.id.road_one1_rock,R.id.road_one2_rock,
            R.id.road_one3_rock,R.id.road_one4_rock,
            R.id.road_one5_rock,R.id.road_one6_rock,
            R.id.road_one7_rock, R.id.road_one8_rock
    };
    private static int[] road_two_rocks = {
            R.id.road_two1_rock,R.id.road_two2_rock,
            R.id.road_two3_rock,R.id.road_two4_rock,
            R.id.road_two5_rock,R.id.road_two6_rock,
            R.id.road_two7_rock,R.id.road_two8_rock
    };
    private static int[] road_three_rocks = {
            R.id.road_three1_rock,R.id.road_three2_rock,
            R.id.road_three3_rock,R.id.road_three4_rock,
            R.id.road_three5_rock,R.id.road_three6_rock,
            R.id.road_three7_rock,R.id.road_three8_rock
    };
    private static int[] road_four_rocks = {
            R.id.road_four1_rock,R.id.road_four2_rock,
            R.id.road_four3_rock,R.id.road_four4_rock,
            R.id.road_four5_rock,R.id.road_four6_rock,
            R.id.road_four7_rock,R.id.road_four8_rock
    };
    private static int[] road_five_rocks = {
            R.id.road_five1_rock,R.id.road_five2_rock,
            R.id.road_five3_rock,R.id.road_five4_rock,
            R.id.road_five5_rock,R.id.road_five6_rock,
            R.id.road_five7_rock,R.id.road_five8_rock
    };
    private static int[] road_one_coins = {
            R.id.road_one1_coin,R.id.road_one2_coin,
            R.id.road_one3_coin,R.id.road_one4_coin,
            R.id.road_one5_coin,R.id.road_one6_coin,
            R.id.road_one7_coin, R.id.road_one8_coin
    };
    private static int[] road_two_coins = {
            R.id.road_two1_coin,R.id.road_two2_coin,
            R.id.road_two3_coin,R.id.road_two4_coin,
            R.id.road_two5_coin,R.id.road_two6_coin,
            R.id.road_two7_coin,R.id.road_two8_coin
    };
    private static int[] road_three_coins = {
            R.id.road_three1_coin,R.id.road_three2_coin,
            R.id.road_three3_coin,R.id.road_three4_coin,
            R.id.road_three5_coin,R.id.road_three6_coin,
            R.id.road_three7_coin,R.id.road_three8_coin
    };
    private static int[] road_four_coins = {
            R.id.road_four1_coin,R.id.road_four2_coin,
            R.id.road_four3_coin,R.id.road_four4_coin,
            R.id.road_four5_coin,R.id.road_four6_coin,
            R.id.road_four7_coin,R.id.road_four8_coin
    };
    private static int[] road_five_coins = {
            R.id.road_five1_coin,R.id.road_five2_coin,
            R.id.road_five3_coin,R.id.road_five4_coin,
            R.id.road_five5_coin,R.id.road_five6_coin,
            R.id.road_five7_coin,R.id.road_five8_coin
    };
    private static int[] car_positions = {
            R.id.car_one,R.id.car_two,R.id.car_three,R.id.car_four,R.id.car_five
    };
    private static int[] img_hearts = {
            R.id.IMG_haert1,R.id.IMG_haert2,R.id.IMG_haert3
    };

    public static int getRoad_one_rocks_Id(int i) {
        return road_one_rocks[i];
    }

    public static int getRoad_two_rocks_Id(int i) {
        return road_two_rocks[i];
    }

    public static int getRoad_three_rocks_Id(int i) {
        return road_three_rocks[i];
    }
    public static int getRoad_four_rocks_Id(int i) {
        return road_four_rocks[i];
    }
    public static int getRoad_five_rocks_Id(int i) {
        return road_five_rocks[i];
    }
    public static int getRoad_one_coins_Id(int i) {
        return road_one_coins[i];
    }

    public static int getRoad_two_coins_Id(int i) {
        return road_two_coins[i];
    }

    public static int getRoad_three_coins_Id(int i) {
        return road_three_coins[i];
    }
    public static int getRoad_four_coins_Id(int i) {
        return road_four_coins[i];
    }
    public static int getRoad_five_coins_Id(int i) {
        return road_five_coins[i];
    }
    public static int getCar_positions_Id(int i) {
        return car_positions[i];
    }

    public static int getImg_hearts_Id(int i) {
        return img_hearts[i];
    }
    public static int getNumOfRows(){
        return NUM_OF_Rows;
    }
    public static int getNumOfLanes(){
        return NUM_OF_LANES;
    }
    public static int getHeartsLength(){
        return img_hearts.length;
    }
    public static int getCarPositionsLength(){
        return car_positions.length;
    }

    public static int getLblScoreId() {
        return lBl_score;
    }
    public static int getLeftBtnId(){
        return left_button;
    }
    public static int getRightBtnId() {
        return right_button;
    }

//    public static ArrayList<Player> getPlayers(){
//        ArrayList<Player> players = new ArrayList<>();
//        players.add(new Player()
//                .setPlayerName("amit")
//                .setPlayerScore(500));
//        players.add(new Player()
//                .setPlayerName("lior")
//                .setPlayerScore(600));
//        return players;
//    }
    public static PlayersList getPlayers() {
        final int numOfPlayers = MAX_NUM_OF_PLAYERS;
        PlayersList playersList = new PlayersList();
        ArrayList<Location> locations = new ArrayList<>();
        String[] playersNames = {"Yaniv", "Avi", "Eli", "Nir", "Tal", "Dan", "Yoni", "Eitan", "Ido", "Tomer"};
        double[] latitudes = {32.11316693778084, 40.7128, 41.8781, 39.9526, 37.7749, 40.7128, 41.8781, 39.9526, 37.7749, 40.7128};
        double[] longitudes = {34.817852408004015, -74.0060, -87.6298, -75.1652, -122.4194, -74.0060, -87.6298, -75.1652, -122.4194, -74.0060};

        // Afeka location :32.11316693778084, 34.817852408004015
        for (int i = 0; i < numOfPlayers; i++) {
            Location newLoc = new Location("location " + i);
            newLoc.setLatitude(latitudes[i]);
            newLoc.setLongitude(longitudes[i]);
            locations.add(newLoc);
        }

        // Create and add each player
        for (int i = 0; i < numOfPlayers; i++) {
            Player player = new Player();
            player.setPlayerName(playersNames[i]);
            player.setPlayerScore(400 + i * 10);
            player.setLocation(locations.get(i));
            playersList.addPlayer(player);
        }
        playersList.sortList();
        playersList.setPlayerListName(getPlayersListJsonKey());
        return playersList;
    }

    public static String getPlayersListJsonKey() {
        return PLAYERS_LIST_JSON_KEY;
    }


}
