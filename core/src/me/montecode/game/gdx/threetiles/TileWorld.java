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

    //TODO set game dimensions according to display

    public TileWorld() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float widthScaleFactor = screenWidth / 480;
        float heightScaleFactor = screenHeight / 800;

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

        Gdx.app.log("SCREEN DIMENSIONS", String.valueOf(screenWidth) + " " + String.valueOf(screenHeight));
    }


    public void update(float delta) {
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

    public Rectangle getPurpleTile() {
        return tilePurple;
    }

    public Rectangle getRedTile() {
        return tileRed;
    }

    public Rectangle getBlueTile() {
        return tileBlue;
    }


}
