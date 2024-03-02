package com.example.myapplicationtomcar;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.example.myapplicationtomcar.R.drawable.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplicationtomcar.R.drawable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    //public static final int NUM_OF_LANES = 3;
    //public static final int NUM_OF_ROWS = 8;
    //public static final int NUM_OF_LIFE = 3;
    //public static final int DELAY = 1000;
    private static MaterialTextView lBL_score;
    private MaterialButton left_button;
    private MaterialButton right_button;
    private static ShapeableImageView[] road_one;
    private static ShapeableImageView[] road_two;
    private static ShapeableImageView[] road_three;
    private static ShapeableImageView[] road_four;
    private static ShapeableImageView[] road_five;
    private static ShapeableImageView[] road_one_coins;
    private static ShapeableImageView[] road_two_coins;
    private static ShapeableImageView[] road_three_coins;
    private static ShapeableImageView[] road_four_coins;
    private static ShapeableImageView[] road_five_coins;
    private static ShapeableImageView[] car_positions;
    private static ShapeableImageView[] iMG_hearts;
    private AlertDialog.Builder builder;
    //private int numOfCrashes;
    //private CountDownTimer gameTimer;
    //private Vibrator vibrator;
    //public Random rand;
    //int score = 0;
    private GameManager gameManager; //+++++++++++++
    private StepDetector stepDetector;

    //MediaPlayer mediaPlayer;
    //String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_roads);
        //vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        builder = new AlertDialog.Builder(this);
        findViews();
        gameManager = new GameManager(GameActivity.this,iMG_hearts.length); //++++++++++++
        //mediaPlayer = MediaPlayer.create(this,R.raw.crash);
        Log.i("amitamit", String.valueOf(gameManager.type));
        left_button.setOnClickListener(view -> moveLeft());
        right_button.setOnClickListener(view -> moveRight());
        setSensorGame(gameManager.type);
        startTime();
    }
    private void setSensorGame(String type){
        if(type == "s"){
            left_button.setVisibility(INVISIBLE);
            right_button.setVisibility(INVISIBLE);
            initStepDetector();
        }
    }

    private void initStepDetector(){
        stepDetector = new StepDetector(this, new StepCallback() {
            @Override
            public void moveLeft() {
                gameManager.moveLeft();
            }

            @Override
            public void moveRight() {
                gameManager.moveRight();
            }
            @Override
            public void increaseSpeed() {
                gameManager.increaseSpeed();
            }

            @Override
            public void decreaseSpeed() {
                gameManager.decreaseSpeed();
            }
        });
    }
    public void moveLeft(){
        gameManager.moveLeft();
    }
//    private void moveLeft(){
//                if(car_positions[0].getVisibility() == VISIBLE){
//                    car_positions[0].setVisibility(INVISIBLE);
//                    car_positions[1].setVisibility(VISIBLE);
//                } else if (car_positions[1].getVisibility() == VISIBLE) {
//                    car_positions[1].setVisibility(INVISIBLE);
//                    car_positions[2].setVisibility(VISIBLE);
//                }
//    }
    public void moveRight(){
        gameManager.moveRight();
    }
//    private void moveRight() {
//                if(car_positions[2].getVisibility() == VISIBLE) {
//                    car_positions[2].setVisibility(INVISIBLE);
//                    car_positions[1].setVisibility(VISIBLE);
//                } else if (car_positions[1].getVisibility() == VISIBLE) {
//                    car_positions[1].setVisibility(INVISIBLE);
//                    car_positions[0].setVisibility(VISIBLE);
//                }
//    }
    public void startTime(){
        gameManager.startTime();
    }
//    private void startTime() {
//        if(gameTimer == null){
//            gameTimer = new CountDownTimer(999999999,DELAY) {
//                @Override
//                public void onTick(long l) {
//                    removeLastLine();
//                    newRock();
//                    moveDown();
//                    checkCrash();
//                }
//
//                @Override
//                public void onFinish() {
//                    gameTimer.cancel();
//                }
//            }.start();
//        }
//    }

//    private void stopTime() {
//        gameTimer.cancel();
//    }

//    private void checkCrash() {
//            if(car_positions[0].getVisibility() == road_one[7].getVisibility()
//                && car_positions[0].getVisibility() == VISIBLE) {
//                addCrash();
//            }
//            if(car_positions[1].getVisibility() == road_two[7].getVisibility()
//                    && car_positions[1].getVisibility() == VISIBLE) {
//                addCrash();
//            }
//            if(car_positions[2].getVisibility() == road_three[7].getVisibility()
//                    && car_positions[2].getVisibility() == VISIBLE) {
//                addCrash();
//            }
//    }

//    private void addCrash() {
//        if(gameManager.getNumOfCrashes() < iMG_hearts.length-1){
//            //score -=10;
//            gameManager.decreasePoints(); //++++++++++
//            mediaPlayer.start();
//            //lBL_score.setText(score + "");
//            lBL_score.setText(gameManager.getScore() + ""); //+++++++++
//            iMG_hearts[gameManager.getNumOfCrashes()].setVisibility(INVISIBLE);
//            //numOfCrashes++;
//            gameManager.increaseNumOfCrashes();
//            Toast.makeText(getApplicationContext(), iMG_hearts.length - gameManager.getNumOfCrashes() +" Hearts Left", Toast.LENGTH_SHORT).show();
//            makeVibrate();
//        }
//        else{
//            Toast.makeText(getApplicationContext(), "Game Over!", Toast.LENGTH_SHORT).show();
//            gameOver();
//        }
//    }

//    private void gameOver() {
//        stopTime();
//        Intent intent = new Intent(getApplicationContext(),GameOverActivity.class);
//        //intent.putExtra("points",score);
//        intent.putExtra("points",gameManager.getScore()); //++++++++++++++++
//        startActivity(intent);
//    }
//    private void newGame() {
//        for (int i=0;i<NUM_OF_ROWS;i++){
//            road_one[i].setVisibility(INVISIBLE);
//            road_two[i].setVisibility(INVISIBLE);
//            road_three[i].setVisibility(INVISIBLE);
//        }
//        for (int i=0;i<NUM_OF_LANES;i++){
//            car_positions[i].setVisibility(INVISIBLE);
//        }
//        for (int i=0;i<iMG_hearts.length;i++){
//            iMG_hearts[i].setVisibility(VISIBLE);
//        }
//        car_positions[1].setVisibility(VISIBLE);
//        //numOfCrashes = 0;
//        //score = 0;
//        gameTimer.start();
//    }

//    private void makeVibrate() {
//        final VibrationEffect vibrationEffect1;
//
//        // this is the only type of the vibration which requires system version Oreo (API 26)
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//
//            // this effect creates the vibration of default amplitude for 1000ms(1 sec)
//            vibrationEffect1 = VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE);
//
//            // it is safe to cancel other vibrations currently taking place
//            vibrator.cancel();
//            vibrator.vibrate(vibrationEffect1);
//        }
//    }

//    private void removeLastLine() {
//        if(road_one[7].getVisibility() == VISIBLE){
//            road_one[7].setVisibility(INVISIBLE);
//            //score +=10;
//            gameManager.increasePoints(); //+++++++++
//            //lBL_score.setText(score + "");
//            lBL_score.setText(gameManager.getScore() + ""); //++++++++++++
//        }
//        if(road_two[7].getVisibility() == VISIBLE){
//            road_two[7].setVisibility(INVISIBLE);
//            //score +=10;
//            gameManager.increasePoints(); //+++++++++
//            //lBL_score.setText(score + "");
//            lBL_score.setText(gameManager.getScore() + ""); //++++++++++++
//        }
//        if(road_three[7].getVisibility() == VISIBLE){
//            road_three[7].setVisibility(INVISIBLE);
//            //score +=10;
//            gameManager.increasePoints(); //+++++++++
//            //lBL_score.setText(score + "");
//            lBL_score.setText(gameManager.getScore() + ""); //++++++++++++
//        }
//    }

//    private void moveDown() {
//        for (int i= NUM_OF_ROWS-1;i>0;i--){
//            if(road_one[i-1].getVisibility() == VISIBLE){
//                road_one[i-1].setVisibility(INVISIBLE);
//                road_one[i].setVisibility(VISIBLE);
//            }
//            if(road_two[i-1].getVisibility() == VISIBLE){
//                road_two[i-1].setVisibility(INVISIBLE);
//                road_two[i].setVisibility(VISIBLE);
//            }
//            if(road_three[i-1].getVisibility() == VISIBLE){
//                road_three[i-1].setVisibility(INVISIBLE);
//                road_three[i].setVisibility(VISIBLE);
//            }
//        }
//    }

//    public void newRock() {
//        int randomRoad = rand.nextInt(NUM_OF_LANES+1);
//        if(randomRoad == 1){
//            road_one[0].setVisibility(VISIBLE);
//        }
//        if(randomRoad == 2){
//            road_two[0].setVisibility(VISIBLE);
//        }
//        if(randomRoad == 3) {
//            road_three[0].setVisibility(VISIBLE);
//        }
//    }
    private void findViews() {
        lBL_score = findViewById(DataManager.getLblScoreId());
        left_button = findViewById(DataManager.getLeftBtnId());
        right_button = findViewById(DataManager.getRightBtnId());
        road_one = new ShapeableImageView[DataManager.getNumOfRows()];
        road_two = new ShapeableImageView[DataManager.getNumOfRows()];
        road_three = new ShapeableImageView[DataManager.getNumOfRows()];
        road_four = new ShapeableImageView[DataManager.getNumOfRows()];
        road_five = new ShapeableImageView[DataManager.getNumOfRows()];
        road_one_coins = new ShapeableImageView[DataManager.getNumOfRows()];
        road_two_coins = new ShapeableImageView[DataManager.getNumOfRows()];
        road_three_coins = new ShapeableImageView[DataManager.getNumOfRows()];
        road_four_coins = new ShapeableImageView[DataManager.getNumOfRows()];
        road_five_coins = new ShapeableImageView[DataManager.getNumOfRows()];
        for (int i=0; i<DataManager.getNumOfRows(); i++) {
            road_one[i] = findViewById(DataManager.getRoad_one_rocks_Id(i));
            road_two[i] = findViewById(DataManager.getRoad_two_rocks_Id(i));
            road_three[i] = findViewById(DataManager.getRoad_three_rocks_Id(i));
            road_four[i] = findViewById(DataManager.getRoad_four_rocks_Id(i));
            road_five[i] = findViewById(DataManager.getRoad_five_rocks_Id(i));
            road_one_coins[i] = findViewById(DataManager.getRoad_one_coins_Id(i));
            road_two_coins[i] = findViewById(DataManager.getRoad_two_coins_Id(i));
            road_three_coins[i] = findViewById(DataManager.getRoad_three_coins_Id(i));
            road_four_coins[i] = findViewById(DataManager.getRoad_four_coins_Id(i));
            road_five_coins[i] = findViewById(DataManager.getRoad_five_coins_Id(i));
        }
        car_positions = new ShapeableImageView[DataManager.getCarPositionsLength()];
        for (int i=0 ; i< DataManager.getCarPositionsLength(); i++)
            car_positions[i] = findViewById(DataManager.getCar_positions_Id(i));
        iMG_hearts = new ShapeableImageView[3];
        for (int i=0 ; i< DataManager.getHeartsLength(); i++)
            iMG_hearts[i] = findViewById(DataManager.getImg_hearts_Id(i));
//        road_one = new ShapeableImageView[]{
//                findViewById(R.id.road_one1),
//                findViewById(R.id.road_one2),
//                findViewById(R.id.road_one3),
//                findViewById(R.id.road_one4),
//                findViewById(R.id.road_one5),
//                findViewById(R.id.road_one6),
//                findViewById(R.id.road_one7),
//                findViewById(R.id.road_one8)
//        };
//        road_two = new ShapeableImageView[]{
//                findViewById(R.id.road_two1),
//                findViewById(R.id.road_two2),
//                findViewById(R.id.road_two3),
//                findViewById(R.id.road_two4),
//                findViewById(R.id.road_two5),
//                findViewById(R.id.road_two6),
//                findViewById(R.id.road_two7),
//                findViewById(R.id.road_two8)
//        };
//        road_three = new ShapeableImageView[]{
//                findViewById(R.id.road_three1),
//                findViewById(R.id.road_three2),
//                findViewById(R.id.road_three3),
//                findViewById(R.id.road_three4),
//                findViewById(R.id.road_three5),
//                findViewById(R.id.road_three6),
//                findViewById(R.id.road_three7),
//                findViewById(R.id.road_three8)
//        };
//        car_positions = new ShapeableImageView[]{
//                findViewById(R.id.car_one),
//                findViewById(R.id.car_two),
//                findViewById(R.id.car_three)
//        };
//        iMG_hearts = new ShapeableImageView[]{
//                findViewById(R.id.IMG_haert1),
//                findViewById(R.id.IMG_haert2),
//                findViewById(R.id.IMG_haert3)
//        };
        //rand = new Random(NUM_OF_LANES + 1);

        //numOfCrashes = 0;
    }
    @Override
    protected void onPause() {
        gameManager.stopTime();
        super.onPause();
    }

    @Override
    protected void onResume() {
        gameManager.startTime();
        if(stepDetector != null)
            stepDetector.start();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        gameManager.stopTime();
        if(stepDetector != null)
            stepDetector.stop();
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        gameManager.stopTime();
        if(stepDetector != null)
            stepDetector.stop();
        super.onStop();
    }
    public static ShapeableImageView[] getRoad_one() { return road_one;}
    public static ShapeableImageView[] getRoad_two() { return road_two;}
    public static ShapeableImageView[] getRoad_three(){ return road_three;}
    public static ShapeableImageView[] getRoad_four(){ return road_four;}
    public static ShapeableImageView[] getRoad_five(){ return road_five;}
    public static ShapeableImageView[] getRoad_one_coins() { return road_one_coins;}
    public static ShapeableImageView[] getRoad_two_coins() { return road_two_coins;}
    public static ShapeableImageView[] getRoad_three_coins(){ return road_three_coins;}
    public static ShapeableImageView[] getRoad_four_coins(){ return road_four_coins;}
    public static ShapeableImageView[] getRoad_five_coins(){ return road_five_coins;}
    public static ShapeableImageView[] getCar_positions(){ return car_positions;};
    public static ShapeableImageView[] getIMG_hearts(){ return iMG_hearts;};
    public static MaterialTextView getScoreText(){ return lBL_score;}
}