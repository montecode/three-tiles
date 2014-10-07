package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by stevyhacker on 5.10.14..
 */
public class TileWorld {

    // 800 x 600
//    private Rectangle tilePurple = new Rectangle(735, 200, 40, 235);
//    private Rectangle tileBlue = new Rectangle(300, 25, 235, 40);
//    private Rectangle tileRed = new Rectangle(25,200, 40, 235);

    // 480 x 800
    private Rectangle tilePurple = new Rectangle(425, 200, 50, 300);
    private Rectangle tileBlue = new Rectangle(130, 15, 300, 50);
    private Rectangle tileRed = new Rectangle(15, 200, 50, 300);


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

        tileRed.width = 50 * widthScaleFactor;
        tilePurple.width = 50 * widthScaleFactor;
        tileBlue.width = 300 * widthScaleFactor;

        tileRed.height = 300 * heightScaleFactor;
        tileBlue.height = 50 * heightScaleFactor;
        tilePurple.height = 300 * heightScaleFactor;

        Gdx.app.log("STATE", "constructor method state READY");

        Gdx.app.log("SCREEN DIMENSIONS", String.valueOf(screenWidth) + " " + String.valueOf(screenHeight));

        currentState = GameState.READY;

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
            centerTilePurpleWidth += tilePurple.width - tilePurple.width /1.00825; // % 1.00825f;
            centerTileBlueWidth +=( tileBlue.width - tileBlue.width / 1.00825)/2;//% 1.00825f;
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

        tileRed.width = 50 * widthScaleFactor;
        tilePurple.width = 50 * widthScaleFactor;
        tileBlue.width = 300 * widthScaleFactor;

        tileRed.height = 300 * heightScaleFactor;
        tileBlue.height = 50 * heightScaleFactor;
        tilePurple.height = 300 * heightScaleFactor;

        passedSeconds = 0;
        runTime = 0;

        centerTilePurpleHeight = 0;
        centerTilePurpleWidth = 0;
        centerTileBlueWidth = 0;

        currentState = GameState.RUNNING;
    }


    public Rectangle getPurpleTile() {
        return tilePurple;
    }

    public Rectangle getRedTile() {
        return tileRed;
    }

    public Rectangle getBlueTile() {
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

}
