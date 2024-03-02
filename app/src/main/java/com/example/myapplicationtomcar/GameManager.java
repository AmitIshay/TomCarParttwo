package com.example.myapplicationtomcar;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.Random;

public class GameManager {
    private static final int ADD_POINTS = 10;
    public int Delay = 1000;

    private Context mainContext;
    private Vibrator vibrator;
    public Random rand;
    private static int score;
    private int life;
    private int numOfCrashes = 0;
    private CountDownTimer gameTimer;
    MediaPlayer mediaPlayer;
    private MaterialTextView lBL_score;

    private ShapeableImageView[] road_one_rocks;
    private ShapeableImageView[] road_two_rocks;
    private ShapeableImageView[] road_three_rocks;
    private ShapeableImageView[] road_four_rocks;
    private ShapeableImageView[] road_five_rocks;
    private ShapeableImageView[] road_one_coins;
    private ShapeableImageView[] road_two_coins;
    private ShapeableImageView[] road_three_coins;
    private ShapeableImageView[] road_four_coins;
    private ShapeableImageView[] road_five_coins;
    private ShapeableImageView[] car_positions;
    private ShapeableImageView[] iMG_hearts;
    private Switch switch_mode;
    //private Switch switch_fast;
    Boolean switchStateMode;
    //Boolean switchStateFast;
    String type;
    private static String playerName;

    public GameManager(Context context,int life){
        this.life = life;
        this.score = 0;
        numOfCrashes = 0;
        this.mainContext = context;
        this.road_one_rocks = GameActivity.getRoad_one();
        this.road_two_rocks = GameActivity.getRoad_two();
        this.road_three_rocks = GameActivity.getRoad_three();
        this.road_four_rocks = GameActivity.getRoad_four();
        this.road_five_rocks = GameActivity.getRoad_five();
        this.road_one_coins = GameActivity.getRoad_one_coins();
        this.road_two_coins = GameActivity.getRoad_two_coins();
        this.road_three_coins = GameActivity.getRoad_three_coins();
        this.road_four_coins = GameActivity.getRoad_four_coins();
        this.road_five_coins = GameActivity.getRoad_five_coins();
        this.car_positions = GameActivity.getCar_positions();
        this.iMG_hearts = GameActivity.getIMG_hearts();
        this.lBL_score = GameActivity.getScoreText();
        mediaPlayer = MediaPlayer.create(context,R.raw.crash);
        vibrator = (Vibrator) mainContext.getSystemService(Context.VIBRATOR_SERVICE);
        //rand = new Random(DataManager.getNumOfLanes() + 1);
        rand = new Random(7);
        this.switch_mode = MainActivity.getSwitchMode();
        //this.switch_fast = MainActivity.getSwitchFast();
        switchStateMode = switch_mode.isChecked();
        //switchStateFast = switch_fast.isChecked();
        this.type = MainActivity.getType();

    }
    public void moveLeft(){
        if(car_positions[0].getVisibility() == VISIBLE){
            car_positions[0].setVisibility(INVISIBLE);
            car_positions[1].setVisibility(VISIBLE);
        } else if (car_positions[1].getVisibility() == VISIBLE) {
            car_positions[1].setVisibility(INVISIBLE);
            car_positions[2].setVisibility(VISIBLE);
        } else if (car_positions[2].getVisibility() == VISIBLE) {
            car_positions[2].setVisibility(INVISIBLE);
            car_positions[3].setVisibility(VISIBLE);
        } else if (car_positions[3].getVisibility() == VISIBLE) {
            car_positions[3].setVisibility(INVISIBLE);
            car_positions[4].setVisibility(VISIBLE);
        }
    }
    public void moveRight(){
        if(car_positions[2].getVisibility() == VISIBLE) {
            car_positions[2].setVisibility(INVISIBLE);
            car_positions[1].setVisibility(VISIBLE);
        } else if (car_positions[1].getVisibility() == VISIBLE) {
            car_positions[1].setVisibility(INVISIBLE);
            car_positions[0].setVisibility(VISIBLE);
        } else if (car_positions[3].getVisibility() == VISIBLE) {
            car_positions[3].setVisibility(INVISIBLE);
            car_positions[2].setVisibility(VISIBLE);
        } else if (car_positions[4].getVisibility() == VISIBLE) {
            car_positions[4].setVisibility(INVISIBLE);
            car_positions[3].setVisibility(VISIBLE);
        }
    }
    public void increaseSpeed(){
    }

    public void decreaseSpeed(){
    }
    public void startTime(){
        if(gameTimer == null){
            if(switchStateMode == false)
                Delay = 1000;
            else
                Delay = 500;
//            if(switchStateFast == true)
//                Delay = 500;
            gameTimer = new CountDownTimer(999999999,Delay) {
                @Override
                public void onTick(long l) {
                    removeLastLine();
                    newRockOrCoin();
                    moveDown();
                    checkCrash();
                    checkCoinCrash();
                }

                @Override
                public void onFinish() {
                    gameTimer.cancel();
                }
            }.start();
        }
    }
    public void stopTime(){
        gameTimer.cancel();
    }
    public void checkCoinCrash(){
        if(car_positions[0].getVisibility() == road_one_coins[7].getVisibility()
                && car_positions[0].getVisibility() == VISIBLE) {
            addCoinCrash();
        }
        if(car_positions[1].getVisibility() == road_two_coins[7].getVisibility()
                && car_positions[1].getVisibility() == VISIBLE) {
            addCoinCrash();
        }
        if(car_positions[2].getVisibility() == road_three_coins[7].getVisibility()
                && car_positions[2].getVisibility() == VISIBLE) {
            addCoinCrash();
        }
        if(car_positions[3].getVisibility() == road_four_coins[7].getVisibility()
                && car_positions[3].getVisibility() == VISIBLE) {
            addCoinCrash();
        }
        if(car_positions[4].getVisibility() == road_five_coins[7].getVisibility()
                && car_positions[4].getVisibility() == VISIBLE) {
            addCoinCrash();
        }
    }
    public void checkCrash(){
        if(car_positions[0].getVisibility() == road_one_rocks[7].getVisibility()
                && car_positions[0].getVisibility() == VISIBLE) {
            addCrash();
        }
        if(car_positions[1].getVisibility() == road_two_rocks[7].getVisibility()
                && car_positions[1].getVisibility() == VISIBLE) {
            addCrash();
        }
        if(car_positions[2].getVisibility() == road_three_rocks[7].getVisibility()
                && car_positions[2].getVisibility() == VISIBLE) {
            addCrash();
        }
        if(car_positions[3].getVisibility() == road_four_rocks[7].getVisibility()
                && car_positions[3].getVisibility() == VISIBLE) {
            addCrash();
        }
        if(car_positions[4].getVisibility() == road_five_rocks[7].getVisibility()
                && car_positions[4].getVisibility() == VISIBLE) {
            addCrash();
        }
    }
    public void addCoinCrash(){
        score += 15;
        lBL_score.setText(score + ""); //+++++++++
    }
    public void addCrash(){
        if(getNumOfCrashes() < iMG_hearts.length-1){
            //score -=10;
            decreasePoints(); //++++++++++
            mediaPlayer.start();
            //lBL_score.setText(score + "");
            lBL_score.setText(score + ""); //+++++++++
            iMG_hearts[getNumOfCrashes()].setVisibility(INVISIBLE);
            //numOfCrashes++;
            increaseNumOfCrashes();
            Toast.makeText(mainContext, iMG_hearts.length - getNumOfCrashes() +" Hearts Left", Toast.LENGTH_SHORT).show();
            makeVibrate();
        }
        else{
            Toast.makeText(mainContext, "Game Over!", Toast.LENGTH_SHORT).show();
            gameOver();
        }
    }
    public void gameOver(){
        stopTime();
        gameOverDialog();
    }
    public void goToRecordActivity(){
        Intent intent = new Intent(mainContext,RecordTableActivity.class);
        //intent.putExtra("points",score); //++++++++++++++++
        mainContext.startActivity(intent);
    }
    public void gameOverDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mainContext);
        builder.setTitle("Enter Your Name");

        // Set up the input
        final EditText input = new EditText(mainContext);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                playerName = input.getText().toString();
                setPlayerName(playerName);
//                if (!playerName.isEmpty()) {
                    //Location playerLocation = SignalGenerator.getInstance().getCurrentLocation(); // assuming a getCurrentLocation() function exists that returns the player's current location
//                    Player player = new Player();
//                    player.setPlayerName(playerName);
//                    player.setPlayerScore(getScore());
//                    player.setPlayerLongitude(34.4);
//                    player.setPlayerLatitude(12.3);
                    //player.setLocation(playerLocation);
//                    playAdapter.addPlayerFromGameOver(player);
//                }
                goToRecordActivity();
            }
        });

        // Make the dialog non-cancelable
        builder.setCancelable(false);

        AlertDialog dialog = builder.create();

        // Show the dialog
        dialog.show();

        // Disable the OK button until the user enters a name
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);

        // Add a listener to the input field to enable the OK button when the user enters a name
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) {
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
                } else {
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    public void makeVibrate(){
        final VibrationEffect vibrationEffect1;

        // this is the only type of the vibration which requires system version Oreo (API 26)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            // this effect creates the vibration of default amplitude for 1000ms(1 sec)
            vibrationEffect1 = VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE);

            // it is safe to cancel other vibrations currently taking place
            vibrator.cancel();
            vibrator.vibrate(vibrationEffect1);
        }
    }
    public void removeLastLine(){
        if(road_one_rocks[7].getVisibility() == VISIBLE){
            road_one_rocks[7].setVisibility(INVISIBLE);
            //score +=10;
            increasePoints(); //+++++++++
            //lBL_score.setText(score + "");
            lBL_score.setText(score + ""); //++++++++++++
        }
        if(road_two_rocks[7].getVisibility() == VISIBLE){
            road_two_rocks[7].setVisibility(INVISIBLE);
            //score +=10;
            increasePoints(); //+++++++++
            //lBL_score.setText(score + "");
            lBL_score.setText(score + ""); //++++++++++++
        }
        if(road_three_rocks[7].getVisibility() == VISIBLE){
            road_three_rocks[7].setVisibility(INVISIBLE);
            //score +=10;
            increasePoints(); //+++++++++
            //lBL_score.setText(score + "");
            lBL_score.setText(score + ""); //++++++++++++
        }
        if(road_four_rocks[7].getVisibility() == VISIBLE){
            road_four_rocks[7].setVisibility(INVISIBLE);
            //score +=10;
            increasePoints(); //+++++++++
            //lBL_score.setText(score + "");
            lBL_score.setText(score + ""); //++++++++++++
        }
        if(road_five_rocks[7].getVisibility() == VISIBLE){
            road_five_rocks[7].setVisibility(INVISIBLE);
            //score +=10;
            increasePoints(); //+++++++++
            //lBL_score.setText(score + "");
            lBL_score.setText(score + ""); //++++++++++++
        }
        if(road_one_coins[7].getVisibility() == VISIBLE){
            road_one_coins[7].setVisibility(INVISIBLE);
//            score +=15;
//            lBL_score.setText(score + ""); //++++++++++++
        }
        if(road_two_coins[7].getVisibility() == VISIBLE){
            road_two_coins[7].setVisibility(INVISIBLE);
//            score +=15;
//            lBL_score.setText(score + ""); //++++++++++++
        }
        if(road_three_coins[7].getVisibility() == VISIBLE){
            road_three_coins[7].setVisibility(INVISIBLE);
//            score +=15;
//            lBL_score.setText(score + ""); //++++++++++++
        }
        if(road_four_coins[7].getVisibility() == VISIBLE){
            road_four_coins[7].setVisibility(INVISIBLE);
//            score +=15;
//            lBL_score.setText(score + ""); //++++++++++++
        }
        if(road_five_coins[7].getVisibility() == VISIBLE){
            road_five_coins[7].setVisibility(INVISIBLE);
//            score +=15;
//            lBL_score.setText(score + ""); //++++++++++++
        }
    }
    public void moveDown(){
        for (int i= DataManager.getNumOfRows()-1;i>0;i--){
            if(road_one_rocks[i-1].getVisibility() == VISIBLE){
                road_one_rocks[i-1].setVisibility(INVISIBLE);
                road_one_rocks[i].setVisibility(VISIBLE);
            }
            if(road_two_rocks[i-1].getVisibility() == VISIBLE){
                road_two_rocks[i-1].setVisibility(INVISIBLE);
                road_two_rocks[i].setVisibility(VISIBLE);
            }
            if(road_three_rocks[i-1].getVisibility() == VISIBLE){
                road_three_rocks[i-1].setVisibility(INVISIBLE);
                road_three_rocks[i].setVisibility(VISIBLE);
            }
            if(road_four_rocks[i-1].getVisibility() == VISIBLE){
                road_four_rocks[i-1].setVisibility(INVISIBLE);
                road_four_rocks[i].setVisibility(VISIBLE);
            }
            if(road_five_rocks[i-1].getVisibility() == VISIBLE){
                road_five_rocks[i-1].setVisibility(INVISIBLE);
                road_five_rocks[i].setVisibility(VISIBLE);
            }
            if(road_one_coins[i-1].getVisibility() == VISIBLE){
                road_one_coins[i-1].setVisibility(INVISIBLE);
                road_one_coins[i].setVisibility(VISIBLE);
            }
            if(road_two_coins[i-1].getVisibility() == VISIBLE){
                road_two_coins[i-1].setVisibility(INVISIBLE);
                road_two_coins[i].setVisibility(VISIBLE);
            }
            if(road_three_coins[i-1].getVisibility() == VISIBLE){
                road_three_coins[i-1].setVisibility(INVISIBLE);
                road_three_coins[i].setVisibility(VISIBLE);
            }
            if(road_four_coins[i-1].getVisibility() == VISIBLE){
                road_four_coins[i-1].setVisibility(INVISIBLE);
                road_four_coins[i].setVisibility(VISIBLE);
            }
            if(road_five_coins[i-1].getVisibility() == VISIBLE){
                road_five_coins[i-1].setVisibility(INVISIBLE);
                road_five_coins[i].setVisibility(VISIBLE);
            }
        }
    }
    public void newRockOrCoin(){
        //int randomRoad = rand.nextInt(DataManager.getNumOfLanes()+1);
        int randomRoad = rand.nextInt(11);
        if(randomRoad == 1){
            road_one_rocks[0].setVisibility(VISIBLE);
        }
        if(randomRoad == 2){
            road_two_rocks[0].setVisibility(VISIBLE);
        }
        if(randomRoad == 3) {
            road_three_rocks[0].setVisibility(VISIBLE);
        }
        if(randomRoad == 4) {
            road_four_rocks[0].setVisibility(VISIBLE);
        }
        if(randomRoad == 5) {
            road_five_rocks[0].setVisibility(VISIBLE);
        }
        if(randomRoad == 6){
            road_one_coins[0].setVisibility(VISIBLE);
        }
        if(randomRoad == 7){
            road_two_coins[0].setVisibility(VISIBLE);
        }
        if(randomRoad == 8){
            road_three_coins[0].setVisibility(VISIBLE);
        }
        if(randomRoad == 9){
            road_four_coins[0].setVisibility(VISIBLE);
        }
        if(randomRoad == 10){
            road_five_coins[0].setVisibility(VISIBLE);
        }
    }
    public static int getScore() {
        return score;
    }
    public int getLife() {
        return life;
    }

    public static String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getNumOfCrashes() {
        return numOfCrashes;
    }

    public int increasePoints(){
        score += 10;
        return score;
    }
    public int decreasePoints(){
        score -= 10;
        return score;
    }
    public int increaseNumOfCrashes(){
        numOfCrashes += 1;
        return numOfCrashes;
    }
}
