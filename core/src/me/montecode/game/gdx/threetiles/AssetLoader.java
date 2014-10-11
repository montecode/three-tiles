package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by stevyhacker on 11.10.14..
 */
public class AssetLoader {

    public static BitmapFont font;

    public static Preferences prefs;

    public static void load() {

        font = new BitmapFont(Gdx.files.internal("data/ubuntu-light.fnt"));
        font.setScale(.25f, -.25f);

        // Create (or retrieve existing) preferences file
        prefs = Gdx.app.getPreferences("ThreeTiles");

        // Provide default high score of 0
        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
        }

    }
    // Receives an integer and maps it to the String highScore in prefs
    public static void setHighScore(int val) {
        prefs.putInteger("highScore", val);
        prefs.flush();
    }

    // Retrieves the current high score
    public static int getHighScore() {
        return prefs.getInteger("highScore");
    }


        public static void dispose() {
        font.dispose();
    }

}
