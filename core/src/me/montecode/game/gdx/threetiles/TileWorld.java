package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by stevyhacker on 5.10.14..
 */
public class TileWorld {

    private Rectangle rect = new Rectangle(0, 0, 50, 35);


    public void update(float delta) {
        rect.x++;
        if (rect.x > 799) {
            rect.x = 0;
        }
        if(rect.x>20){
           rect.y++;
        }
        Gdx.app.log("GameWorld", "update");
        if (rect.y > 605) {
            rect.y = 0;
        }

    }

    public Rectangle getRect() {
        return rect;
    }


}
