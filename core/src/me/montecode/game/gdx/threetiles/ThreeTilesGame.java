package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.Game;

public class ThreeTilesGame extends Game {

	@Override
	public void create () {
        AssetLoader.load();
        setScreen(new MainGameScreen(this));

	}

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }

	@Override
	public void render () {
		super.render();
	}
}
