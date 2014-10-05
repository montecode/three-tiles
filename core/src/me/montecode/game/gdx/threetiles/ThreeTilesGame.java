package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.Game;

public class ThreeTilesGame extends Game {

	@Override
	public void create () {
        setScreen(new MainGameScreen(this));

	}

	@Override
	public void render () {
		super.render();
	}
}
