package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * Created by stevyhacker on 5.10.14..
 */
public class MainGameScreen implements Screen {
   ThreeTilesGame game;
   TileWorld world;
   TileRenderer renderer;



    public MainGameScreen(ThreeTilesGame game) {


//        float gameWidth = 480;
//        float gameHeight = screenHeight / (screenWidth/gameWidth);

        this.game = game;
        world = new TileWorld();
        renderer = new TileRenderer(world);
        Gdx.input.setInputProcessor(new InputHandler(world));

    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
