package me.montecode.game.gdx.threetiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Queue;

/**
 * Created by stevyhacker on 5.10.14..
 */
public class TileRenderer {
    private OrthographicCamera camera;
    private SpriteBatch batcher;
    private ShapeRenderer shapeRenderer;
    private TileWorld world;

    public TileRenderer(TileWorld world) {
        this.world = world;

        camera = new OrthographicCamera(480, 800);
        camera.setToOrtho(true);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

    }

    public void render(float delta) {

         /*
         * 1. We draw background. This prevents flickering.
         */

        Gdx.gl.glClearColor(243, 236, 205, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*
         * 2. We draw the Filled tile
         */

        // Tells shapeRenderer to begin drawing filled shapes
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Colors
        // purple 43 19 55
        // red/pink 236 14 93
        // blue 29 192 206

        shapeRenderer.setColor(43 / 255.0f, 19 / 255.0f, 55 / 255.0f, 1);
        shapeRenderer.rect(world.getPurpleTile().x, world.getPurpleTile().y,
                world.getPurpleTile().width, world.getPurpleTile().height);


        shapeRenderer.setColor(236 / 255.0f, 14 / 255.0f, 93 / 255.0f, 1);
        shapeRenderer.rect(world.getRedTile().x, world.getRedTile().y,
                world.getRedTile().width, world.getRedTile().height);

        shapeRenderer.setColor(29 / 255.0f, 192 / 255.0f, 206 / 255.0f, 1);
        shapeRenderer.rect(world.getBlueTile().x, world.getBlueTile().y,
                world.getBlueTile().width, world.getBlueTile().height);

        Queue<Tile> tileQueue = world.getTileQueue();

        for (Tile tile : tileQueue) {
            switch (tile.color) {
                case 1: //PURPLE
                    shapeRenderer.setColor(43 / 255.0f, 19 / 255.0f, 55 / 255.0f, 1);
                    shapeRenderer.rect(tile.x, tile.y,
                            tile.width, tile.height);
                    break;
                case 2: //RED
                    shapeRenderer.setColor(236 / 255.0f, 14 / 255.0f, 93 / 255.0f, 1);
                    shapeRenderer.rect(tile.x, tile.y,
                            tile.width, tile.height);
                    break;
                default:  //BLUE
                    shapeRenderer.setColor(29 / 255.0f, 192 / 255.0f, 206 / 255.0f, 1);
                    shapeRenderer.rect(tile.x, tile.y,
                            tile.width, tile.height);
                    break;
            }
        }

        if (world.getSwipedTile() != null) {
            Tile swipedTile = world.getSwipedTile();
            switch (swipedTile.color) {

                case 1: //PURPLE
                shapeRenderer.setColor(43 / 255.0f, 19 / 255.0f, 55 / 255.0f, 1);
                shapeRenderer.rect(swipedTile.x, swipedTile.y,
                        swipedTile.width, swipedTile.height);
                break;
            case 2: //RED
                shapeRenderer.setColor(236 / 255.0f, 14 / 255.0f, 93 / 255.0f, 1);
                shapeRenderer.rect(swipedTile.x, swipedTile.y,
                        swipedTile.width, swipedTile.height);
                break;
            default:  //BLUE
                shapeRenderer.setColor(29 / 255.0f, 192 / 255.0f, 206 / 255.0f, 1);
                shapeRenderer.rect(swipedTile.x, swipedTile.y,
                        swipedTile.width, swipedTile.height);
                break;
        }
    }

    shapeRenderer.end();

    batcher.begin();

    if(world.isReady())

    {
        AssetLoader.fontText.draw(batcher, "Swipe the tiles to play", world.screenWidth / 2 - world.screenWidth / 3.5f, world.screenHeight / 2 - world.screenHeight / 8);
    }

    if(world.isRunning())

    {
        AssetLoader.font.draw(batcher, String.valueOf(world.getScore()), 25 * world.widthScaleFactor, 50 * world.heightScaleFactor);
    }

    AssetLoader.font.draw(batcher,"FPS:"+Gdx.graphics.getFramesPerSecond(),world.screenWidth-150*world.widthScaleFactor,world.screenHeight-50*world.heightScaleFactor);
    if(world.isGameOver())

    {
        AssetLoader.font.draw(batcher, "Your score: " + String.valueOf(world.getScore()), world.screenWidth / 2 - world.screenWidth / 3.5f, world.screenHeight / 2 - world.screenHeight / 3);
        AssetLoader.font.draw(batcher, "High score: " + String.valueOf(world.getHighScore()), world.screenWidth / 2 - world.screenWidth / 3.5f, world.screenHeight / 2 - world.screenHeight / 4);

        AssetLoader.fontText.draw(batcher, "Swipe the tiles to play", world.screenWidth / 2 - world.screenWidth / 3.5f, world.screenHeight / 2 - world.screenHeight / 8);
    }

    batcher.end();

    // Tells shapeRenderer to draw an outline of the following shapes
//        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//
//        // Chooses RGB Color of 255, 109, 120 at full opacity
//        shapeRenderer.setColor(255 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);
//
//        // Draws the tile from world (Using ShapeType.Line)
//        shapeRenderer.rect(world.getPurpleTile().x, world.getPurpleTile().y,
//                world.getPurpleTile().width, world.getPurpleTile().height);
//
//        shapeRenderer.end();

}
}
