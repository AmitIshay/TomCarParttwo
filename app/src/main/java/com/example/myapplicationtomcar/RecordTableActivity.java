package com.example.myapplicationtomcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecordTableActivity extends AppCompatActivity {
    //private RecyclerView recycler_list;
    //private ArrayList<Player> playersList;
    //PlayersList pL;
    private ListFragment listFragment;
    private MapFragment mapFragment;


    private PlayersListClickCallback playerCallback = new PlayersListClickCallback() {
        @Override
        public void itemClicked(Player player, int position, Location location) {
            mapFragment.zoomOnRecord(player);
        }

        @Override
        public void zoomOnRecord(Player player) {

            mapFragment.zoomOnRecord(player);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_table);
        //findViews();
        //initViews();
        initFragments();
        beginTransactions();
    }
    private void initViews() {
//        playersList = PrefConfig.readListFromPref(this);
//        if(playersList == null)
//            playersList = new ArrayList<>();
//        pL = PrefConfig.readListFromPref(this);
//        if(pL == null)
//            pL = new PlayersList();
//
//        //PlayerAdapter playerAdapter = new PlayerAdapter(getApplicationContext(), DataManager.getPlayers()); ----
////        PlayerAdapter playerAdapter = new PlayerAdapter(getApplicationContext(), playersList);
//        PlayerAdapter playerAdapter = new PlayerAdapter(getApplicationContext(), pL);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
//        recycler_list.setLayoutManager(linearLayoutManager);
//        recycler_list.setAdapter(playerAdapter);
//        if(!GameManager.getPlayerName().isEmpty()) {
//            Player p = new Player();
//            p.setPlayerName(GameManager.getPlayerName());
//            p.setPlayerScore(GameManager.getScore());
//            p.setPlayerLatitude(13.5);
//            p.setPlayerLongitude(34.5);
//            pL.addPlayer(p);
//        }
////        Player p = new Player();
////        p.setPlayerName("momo");
////        p.setPlayerScore(400);
////        playersList.add(p);
////        pL = DataManager.getPlayers();
////        playersList.sort();
////        pL.sortList();
////        Log.i("amitamit", String.valueOf(pL));
////        PrefConfig.writeListInPref(getApplicationContext(),playersList);
////        Player player = new Player();
////        player.setPlayerName("momooooo");
////        player.setPlayerScore(1800);
////        player.setPlayerLatitude(15.5);
////        player.setPlayerLongitude(12.4);
////        pL.addPlayer(player);
//
//        PrefConfig.writeListInPref(getApplicationContext(),pL);
//
//
//        playerAdapter.setMovieCallback(new PlayerCallback() {
//            @Override
//            public void favoriteButtonClicked(Player player, int position) {
//                recycler_list.getAdapter().notifyDataSetChanged();
//            }
//        });
    }
//    private void findViews() {
//        //recycler_list = findViewById(R.id.recycler_list);
//    }
    private void beginTransactions() {
        getSupportFragmentManager().beginTransaction().add(R.id.main_FRAME_list, listFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_FRAME_map, mapFragment).commit();
    }
    private void initFragments() {
        listFragment = new ListFragment();
        listFragment.setPlayerCallback(playerCallback);
        mapFragment = new MapFragment();

    }

}