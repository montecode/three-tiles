package me.montecode.game.gdx.threetiles.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.montecode.game.gdx.threetiles.ThreeTilesGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Three Tiles";
        config.width = 480;
        config.height = 800;
		new LwjglApplication(new ThreeTilesGame(), config);
	}
}
