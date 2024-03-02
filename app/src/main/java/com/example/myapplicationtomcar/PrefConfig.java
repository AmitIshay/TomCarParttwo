package com.example.myapplicationtomcar;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.Preference;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PrefConfig {
    private static final String LIST_KEY = "list_keyyy";
//    public static void writeListInPref(Context context, ArrayList<Player> players){
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(players);
//        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putString(LIST_KEY, jsonString);
//        editor.apply();
//    }
    public static void writeListInPref(Context context, PlayersList players){
        Gson gson = new Gson();
        String jsonString = gson.toJson(players);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }
//    public static ArrayList<Player> readListFromPref(Context context){
//        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
//        String jsonString = pref.getString(LIST_KEY,"");
//        Gson gson = new Gson();
//        Type type = new TypeToken<ArrayList<Player>>() {}.getType();
//        ArrayList<Player> playersList = gson.fromJson(jsonString, type);
//        return playersList;
//    }
    public static PlayersList readListFromPref(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY,"");
        Gson gson = new Gson();
        //Type type = new TypeToken<ArrayList<Player>>() {}.getType();
        Type type = new TypeToken<PlayersList>() {}.getType();
        PlayersList playersList = gson.fromJson(jsonString, type);
        return playersList;
    }
}
