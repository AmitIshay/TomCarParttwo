package com.example.myapplicationtomcar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {
    private Context context;
    //private ArrayList<Player> players;
    PlayersList players;
    private PlayerCallback playerCallback;
    private PlayersListClickCallback playersListClick_callback;


    public PlayerAdapter(Context context, PlayersList players) {
        this.context = context;
        this.players = players;
    }
    public PlayerAdapter setMovieCallback(PlayerCallback playerCallback) {
        this.playerCallback = playerCallback;
        return this;
    }
//    public void setPlayersListClick_callback(PlayersListClickCallback playersListClick_callback) {
//        this.playersListClick_callback = playersListClick_callback;
//    }
    public PlayerAdapter setPlayersListClick_callback(PlayersListClickCallback playersListClick_callback){
        this.playersListClick_callback = playersListClick_callback;
        return this;
    }
    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item, parent, false);
        return new PlayerViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = getItem(position);

        holder.player_name.setText(player.getPlayerName());
        holder.player_score.setText(String.valueOf(player.getPlayerScore()));
    }
//    public int getItemCount() {
//        return players == null ? 0 : players.size();
//    }
    public int getItemCount() {
    return players == null ? 0 : players.getListSize();
}

//    private Player getItem(int position) {
//        return players.get(position);
//    }
    private Player getItem(int position) {
    return players.getPlayerByPosition(position);
}

    public class PlayerViewHolder extends RecyclerView.ViewHolder {

        private MaterialTextView player_name;
        private MaterialTextView player_score;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            player_name = itemView.findViewById(R.id.player_name);
            player_score = itemView.findViewById(R.id.player_score);
            itemView.setOnClickListener(v -> {
                if (playersListClick_callback != null) {
                    Player player = getItem(getAdapterPosition());
                    playersListClick_callback.itemClicked(player, getAdapterPosition(), player.getLocation());
                }
            });
        }
    }
}
