package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.Gdx;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by stevyhacker on 5.10.14..
 */
public class TileWorld {

    // 480 x 800
    private Tile tilePurple = new Tile(425, 200, 50, 300);
    private Tile tileBlue = new Tile(130, 15, 300, 50);
    private Tile tileRed = new Tile(15, 200, 50, 300);
    public Tile swipedTile;

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

    float divider = 1.00925f;

    private int score = 0;


    public enum GameState {
        READY, RUNNING, GAMEOVER
    }

    public TileWorld() {

        tileRed.width = 60 * widthScaleFactor;
        tilePurple.width = 60 * widthScaleFactor;
        tileBlue.width = 300 * widthScaleFactor;

        tileRed.height = 300 * heightScaleFactor;
        tileBlue.height = 60 * heightScaleFactor;
        tilePurple.height = 300 * heightScaleFactor;

        tilePurple.x = 405 * widthScaleFactor;
        tileRed.x = 15 * widthScaleFactor;
        tileBlue.x = (screenWidth / 2) - tileBlue.width / 2;//90 * widthScaleFactor;

        tilePurple.y = (screenHeight / 2) - tilePurple.height / 2;
        tileRed.y = (screenHeight / 2) - tileRed.height / 2;
        tileBlue.y = 15 * heightScaleFactor;

        for (int i = 0; i < 5; i++) {
            tileQueue.add(new Tile(200 * widthScaleFactor, (400 * heightScaleFactor) + i * 80 * heightScaleFactor, 80 * widthScaleFactor, 80 * heightScaleFactor));
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
            case GAMEOVER:
                updateGameOver(delta);
                break;
        }

    }

    private void updateGameOver(float delta) {

        if (score > AssetLoader.getHighScore()) {
            AssetLoader.setHighScore(score);
        }

    }

    private void updateReady(float delta) {


    }

    public void updateRunning(float delta) {
//        Gdx.app.log("DELTA WORLD ", String.valueOf(delta));
//        Gdx.app.log("STATE", "UPDATE RUNNING METHOD STATE RUNNING");

        runTime += delta;

        if (runTime > 0.02) {
            passedSeconds += runTime;
            runTime = 0;
            centerTilePurpleWidth = ((60 * widthScaleFactor) - tilePurple.width / divider);
            tilePurple.width /= divider;
            tileRed.width /= divider;
            tileBlue.width /= divider;

            tilePurple.height /= divider;
            tileRed.height /= divider;
            tileBlue.height /= divider;

            tilePurple.x = (405 * widthScaleFactor) + centerTilePurpleWidth;
            tileBlue.x = (screenWidth / 2) - tileBlue.width / 2;

            tilePurple.y = (screenHeight / 2) - tilePurple.height / 2;
            tileRed.y = (screenHeight / 2) - tileRed.height / 2;

            divider = divider * 1.00006f;
        }

        if (swipedTile != null) {
            swipedTile.width /= 1.1;
            swipedTile.height /= 1.1;

            switch (swipedTile.direction) {

                case 1: //PURPLE
                    swipedTile.x +=screenWidth * 1.04 - screenWidth;
                    swipedTile.y = (screenHeight / 2) - swipedTile.height / 2;
                    break;
                case 2: //RED
                    swipedTile.x -=screenWidth * 1.04 - screenWidth;
                    swipedTile.y = (screenHeight / 2) - swipedTile.height / 2;

                    break;
                default:  //BLUE
                   swipedTile.y-= screenHeight * 1.04 - screenHeight;
                   swipedTile.x= (screenWidth / 2) -swipedTile.width / 2;
                     break;
            }
        }

        if (tileBlue.width < 25 * widthScaleFactor) {

            Gdx.app.log("STATE", "UPDATE RUNNING METHOD STATE GAME OVER");
            Gdx.app.log("gameover", " purple height: " + String.valueOf(tilePurple.height) + " blue width: " + String.valueOf(tileBlue.width));

            tilePurple.width = 0;
            tileRed.width = 0;
            tileBlue.width = 0;

            tilePurple.height = 0;
            tileRed.height = 0;
            tileBlue.height = 0;
            currentState = GameState.GAMEOVER;
        }
//        }
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

    public void swipePurple() {
        swipedTile = tileQueue.poll();
        swipedTile.direction=1;
        Gdx.app.log("TILECOLOR", " COLOR INT: " + String.valueOf(swipedTile.color));


        if (swipedTile.color == 1) {
            enlargeTiles();
        } else {
            shrinkTiles();
        }
        addTile();
    }

    public void swipeRed() {
        swipedTile = tileQueue.poll();
        swipedTile.direction=2;
        Gdx.app.log("TILECOLOR", " COLOR INT: " + String.valueOf(swipedTile.color));

        if (swipedTile.color == 2) {
            enlargeTiles();
        } else {
            shrinkTiles();
        }
        addTile();
    }

    public void swipeBlue() {
        swipedTile = tileQueue.poll();
        swipedTile.direction=3;
        Gdx.app.log("TILECOLOR", " COLOR INT: " + String.valueOf(swipedTile.color));

        if (swipedTile.color == 3) {
            enlargeTiles();
        } else {
            shrinkTiles();
        }
        addTile();
    }

    public void enlargeTiles() {
        score++;
        tilePurple.width *= 1.205;
        tileRed.width *= 1.205;
        tileBlue.width *= 1.205;

        tilePurple.height *= 1.205;
        tileRed.height *= 1.205;
        tileBlue.height *= 1.205;
    }

    public void shrinkTiles() {
        tilePurple.width /= 1.205;
        tileRed.width /= 1.205;
        tileBlue.width /= 1.205;

        tilePurple.height /= 1.205;
        tileRed.height /= 1.205;
        tileBlue.height /= 1.205;
    }

    public void addTile() {
        for (Tile tile : tileQueue) {
            tile.y -= 80 * heightScaleFactor;
        }

        tileQueue.add(new Tile(200 * widthScaleFactor, (400 * heightScaleFactor) + 4 * 80 * heightScaleFactor, 80 * widthScaleFactor, 80 * heightScaleFactor));
    }

    public void restart() {
        Gdx.app.log("STATE", "restarting method state RUNNING");

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float widthScaleFactor = screenWidth / 480;
        float heightScaleFactor = screenHeight / 800;

        tileRed.width = 60 * widthScaleFactor;
        tilePurple.width = 60 * widthScaleFactor;
        tileBlue.width = 300 * widthScaleFactor;

        tileRed.height = 300 * heightScaleFactor;
        tileBlue.height = 60 * heightScaleFactor;
        tilePurple.height = 300 * heightScaleFactor;

        tilePurple.x = 405 * widthScaleFactor;
        tileRed.x = 15 * widthScaleFactor;
        tileBlue.x = (screenWidth / 2) - tileBlue.width / 2;

        tileBlue.y = 15 * heightScaleFactor;
        tilePurple.y = (screenHeight / 2) - tilePurple.height / 2;
        tileRed.y = (screenHeight / 2) - tileRed.height / 2;

        passedSeconds = 0;
        runTime = 0;

        centerTilePurpleHeight = 0;
        centerTilePurpleWidth = 0;
        centerTileBlueWidth = 0;

        while (!tileQueue.isEmpty()) {
            tileQueue.remove();
        }

        for (int i = 0; i < 5; i++) {
            tileQueue.add(new Tile(200 * widthScaleFactor, (400 * heightScaleFactor) + i * 80 * heightScaleFactor, 80 * widthScaleFactor, 80 * heightScaleFactor));
        }

        divider = 1.00925f;
        score = 0;
        swipedTile=null;
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

    public boolean isRunning() {
        return currentState == GameState.RUNNING;
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

    public int getScore() {
        return score;
    }

    public Tile getSwipedTile() {
        return swipedTile;
    }

    public int getHighScore() {
        return AssetLoader.getHighScore();
    }

}
