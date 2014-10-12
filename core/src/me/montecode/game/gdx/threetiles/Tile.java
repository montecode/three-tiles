package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by stevyhacker on 7.10.14..
 */
public class Tile extends Rectangle {
    int color;
    int direction;

    public Tile(float x, float y, float width, float height) {
        super(x, y, width, height);
        Random random = new Random();
        color = random.nextInt(3)+1;

    }


}
