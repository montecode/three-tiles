package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by stevyhacker on 6.10.14..
 */
public class InputHandler implements InputProcessor {
    private TileWorld world;

    public InputHandler(TileWorld world) {
        this.world = world;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (world.isReady()) {
            Gdx.app.log("STATE", " TOUCH DOWN is ready if state READY");

            world.start();
        }

        if (world.isGameOver()){
            Gdx.app.log("STATE", "TOUCH DOWN IS GAME OVER restarting method state GAME OVER");
            world.restart();
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
