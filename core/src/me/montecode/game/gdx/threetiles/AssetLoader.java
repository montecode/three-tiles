package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by stevyhacker on 11.10.14..
 */

public class AssetLoader {

    public static BitmapFont font;
    public static BitmapFont font2;
    public static BitmapFont fontFF;

    public static Preferences prefs;


    public static void load() {

        font2 = new BitmapFont();
        font2.setColor(Color.BLACK);
        font2.setScale(1.5f,-1.5f);


        FreeTypeFontGenerator generator = new FreeTypeFontGenerator((Gdx.files.internal("data/RobotoCondensed-Regular.ttf")));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.kerning=true;
        fontParameter.flip=true;
        fontParameter.size=48;
         fontFF = generator.generateFont(fontParameter);
         fontFF.setColor(Color.BLACK);
        generator.dispose();

        font = new BitmapFont(Gdx.files.internal("data/roboto-regular.fnt"));
        font.setColor(Color.BLACK);
        font.setScale(0.5f, -0.5f);

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
