package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.Gdx;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by stevyhacker on 5.10.14..
 */
public class TileWorld {

    // 800 x 600
//    private Tile tilePurple = new Tile(735, 200, 40, 235);
//    private Tile tileBlue = new Tile(300, 25, 235, 40);
//    private Tile tileRed = new Tile(25,200, 40, 235);

    // 480 x 800
    private Tile tilePurple = new Tile(425, 200, 50, 300);
    private Tile tileBlue = new Tile(130, 15, 300, 50);
    private Tile tileRed = new Tile(15, 200, 50, 300);

    private Tile tile = new Tile(15, 200, 50, 300);


    Queue<Tile> tileQueue = new LinkedList<Tile>();

    float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();
    float widthScaleFactor = screenWidth / 480;
    float heightScaleFactor = screenHeight / 800;

    float centerTilePurpleWidth;
    float centerTilePurpleHeight;
    float centerTileBlueWidth;

    private GameState currentState;

    float runTime;
    float passedSeconds = 0;

    public enum GameState {
        READY, RUNNING, GAMEOVER
    }

    public TileWorld() {

        // EXAMPLE 480.0 800.0
        tilePurple.x = 415 * widthScaleFactor;
        tileRed.x = 15 * widthScaleFactor;
        tileBlue.x = 90 * widthScaleFactor;

        tilePurple.y = 200 * heightScaleFactor;
        tileRed.y = 200 * heightScaleFactor;
        tileBlue.y = 15 * heightScaleFactor;

        tileRed.width = 60 * widthScaleFactor;
        tilePurple.width = 60 * widthScaleFactor;
        tileBlue.width = 300 * widthScaleFactor;

        tileRed.height = 300 * heightScaleFactor;
        tileBlue.height = 60 * heightScaleFactor;
        tilePurple.height = 300 * heightScaleFactor;

        for (int i = 0; i < 5; i++) {
            tileQueue.add(new Tile(200*widthScaleFactor,(400*heightScaleFactor)+i*80*heightScaleFactor,80*widthScaleFactor,80*heightScaleFactor));
        }

        Gdx.app.log("STATE", "constructor method state READY");

        Gdx.app.log("SCREEN DIMENSIONS", String.valueOf(screenWidth) + " " + String.valueOf(screenHeight));

        currentState = GameState.READY;

        //TODO CREATE ASSET LOADER FOR FONTS AND SHOW WELCOME MESSAGE WITH HINTS
    }

    public void update(float delta) {

        switch (currentState) {
            case READY:
                updateReady(delta);
                break;

            case RUNNING:
                updateRunning(delta);
                break;
            default:
                break;
        }

    }

    private void updateReady(float delta) {


    }

    public void updateRunning(float delta) {
//        Gdx.app.log("DELTA WORLD ", String.valueOf(delta));
//        Gdx.app.log("STATE", "UPDATE RUNNING METHOD STATE RUNNING");

        // center tiles while shrinking
        runTime += delta;

        if (runTime > 0.02) {
            passedSeconds += runTime;
            runTime = 0;
            centerTilePurpleWidth += tilePurple.width - tilePurple.width / 1.00825; // % 1.00825f;
            centerTileBlueWidth += (tileBlue.width - tileBlue.width / 1.00825) / 2;//% 1.00825f;
            tilePurple.width /= 1.00825;
            tileRed.width /= 1.00825;
            tileBlue.width /= 1.00825;

            tilePurple.height /= 1.00825;
            tileRed.height /= 1.00825;
            tileBlue.height /= 1.00825;

            centerTilePurpleHeight += tilePurple.height % 1.00825f;


            tilePurple.x = (415 * widthScaleFactor) + centerTilePurpleWidth;
            tileRed.x = 15 * widthScaleFactor;
            tileBlue.x = (90 * widthScaleFactor) + centerTileBlueWidth;

            tilePurple.y = (200 * heightScaleFactor) + centerTilePurpleHeight;
            tileRed.y = 200 * heightScaleFactor + centerTilePurpleHeight;
            tileBlue.y = 15 * heightScaleFactor;

        }

        if (passedSeconds > 5) {
            Gdx.app.log("STATE", "UPDATE RUNNING METHOD STATE GAME OVER");

            currentState = GameState.GAMEOVER;
        }
//        tilePurple.x++;
//        if (tilePurple.x > 799) {
//            tilePurple.x = 0;
//        }
//        if (tilePurple.x > 20) {
//            tilePurple.y++;
//        }
//        Gdx.app.log("GameWorld", "update");
//        if (tilePurple.y > 605) {
//            tilePurple.y = 0;
//        }

    }

    public void restart() {
        Gdx.app.log("STATE", "restarting method state RUNNING");

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float widthScaleFactor = screenWidth / 480;
        float heightScaleFactor = screenHeight / 800;

        tilePurple.x = 415 * widthScaleFactor;
        tileRed.x = 15 * widthScaleFactor;
        tileBlue.x = 90 * widthScaleFactor;

        tilePurple.y = 200 * heightScaleFactor;
        tileRed.y = 200 * heightScaleFactor;
        tileBlue.y = 15 * heightScaleFactor;

        tileRed.width = 60 * widthScaleFactor;
        tilePurple.width = 60 * widthScaleFactor;
        tileBlue.width = 300 * widthScaleFactor;

        tileRed.height = 300 * heightScaleFactor;
        tileBlue.height = 60 * heightScaleFactor;
        tilePurple.height = 300 * heightScaleFactor;

        passedSeconds = 0;
        runTime = 0;

        centerTilePurpleHeight = 0;
        centerTilePurpleWidth = 0;
        centerTileBlueWidth = 0;

        while (!tileQueue.isEmpty()) {
            tileQueue.remove();
        }

        for (int i = 0; i < 5; i++) {
            tileQueue.add(new Tile(200*widthScaleFactor,(400*heightScaleFactor)+i*80*heightScaleFactor,80*widthScaleFactor,80*heightScaleFactor));
        }

        currentState = GameState.RUNNING;
    }


    public Tile getPurpleTile() {
        return tilePurple;
    }

    public Tile getRedTile() {
        return tileRed;
    }

    public Tile getBlueTile() {
        return tileBlue;
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public Queue<Tile> getTileQueue() {
        return tileQueue;
    }
}
