package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by stevyhacker on 5.10.14..
 */
public class TileWorld {

    private Rectangle tilePurple = new Rectangle(735, 200, 40, 235);
    private Rectangle tileBlue = new Rectangle(300, 25, 235, 40);
    private Rectangle tileRed = new Rectangle(25,200, 40, 235);



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
