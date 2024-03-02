package com.example.myapplicationtomcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ListFragment extends Fragment {
    private RecyclerView recycler_list;
    PlayersList pL;
    private PlayersListClickCallback playerCallback;

    public ListFragment() {
    }
    public void setPlayerCallback(PlayersListClickCallback sendClicked) {
        this.playerCallback = sendClicked;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        findViews(view);
        initViews();
        return view;
    }
    private void initViews(){
        pL = PrefConfig.readListFromPref(getContext());
        if(pL == null) {
            pL = new PlayersList();
        }

        //PlayerAdapter playerAdapter = new PlayerAdapter(getApplicationContext(), DataManager.getPlayers()); ----
//        PlayerAdapter playerAdapter = new PlayerAdapter(getApplicationContext(), playersList);
        PlayerAdapter playerAdapter = new PlayerAdapter(getContext(), pL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler_list.setLayoutManager(linearLayoutManager);
        recycler_list.setAdapter(playerAdapter);
        if(MainActivity.getNum() == 1) {
            Player p = new Player();
            p.setPlayerName(GameManager.getPlayerName());
            p.setPlayerScore(GameManager.getScore());
            p.setPlayerLatitude(32.08);
            p.setPlayerLongitude(34.8);
//            p.setLocation(GameManager.getPlayerLocation());
            pL.addPlayer(p);
        }
//        Player p = new Player();
//        p.setPlayerName("momo");
//        p.setPlayerScore(400);
//        playersList.add(p);
//        pL = DataManager.getPlayers();
//        playersList.sort();
//        pL.sortList();
//        Log.i("amitamit", String.valueOf(pL));
//        PrefConfig.writeListInPref(getApplicationContext(),playersList);
//        Player player = new Player();
//        player.setPlayerName("momooooo");
//        player.setPlayerScore(1800);
//        player.setPlayerLatitude(15.5);
//        player.setPlayerLongitude(12.4);
//        pL.addPlayer(player);

        PrefConfig.writeListInPref(getContext(),pL);
        playerAdapter.setPlayersListClick_callback(new PlayersListClickCallback() {
            @Override
            public void itemClicked(Player Player, int position, Location location) {
                Toast.makeText(getContext(),Player.getPlayerName(), Toast.LENGTH_SHORT).show();
                playerCallback.zoomOnRecord(Player);
            }

            @Override
            public void zoomOnRecord(Player player) {
                if(playerCallback != null)
                    playerCallback.zoomOnRecord(player);
            }
        });
//
//        playerAdapter.setMovieCallback(new PlayerCallback() {
//            @Override
//            public void favoriteButtonClicked(Player player, int position) {
//                recycler_list.getAdapter().notifyDataSetChanged();
//            }
//        });
    }

    private void findViews(View view) {
        recycler_list = view.findViewById(R.id.recycler_list);
    }
}