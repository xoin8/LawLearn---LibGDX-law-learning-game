package io.github.quillraven.slimesur;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.github.tommyettinger.textra.Font;
import com.github.tommyettinger.textra.TypingAdapter;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.w3c.dom.Text;
import com.github.tommyettinger.textra.TypingLabel;

public class TestScreen implements Screen,InputProcessor {
    private Game game;
    private SpriteBatch batch;
    private Stage stage;
    private InputMultiplexer multiplexer;
    private OrthographicCamera camera;
    private ExtendViewport viewport;

    private Texture background;
    float lasttouchY;

    public TestScreen(Game game) {
        this.game = game;
        batch = new SpriteBatch();

        camera = new OrthographicCamera();

        // Virtual resolution
        viewport = new ExtendViewport(900,1600,camera);

        background = new Texture(Gdx.files.internal("whitebackground.png"));

        viewport.apply();
        camera.position.set(
            viewport.getWorldWidth() / 2f,
            viewport.getWorldHeight() / 2f,
            0
        );
        camera.update();
    }
    Texture abc=new Texture(Gdx.files.internal("higu.png"));
    float imageX = 100;
    float imageY = 100;
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
lasttouchY=screenY;
        System.out.println("Touch Down");
        System.out.println("X = " + screenX);
        System.out.println("Y = " + screenY);

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("Dragging");
        System.out.println("X = " + screenX);
        System.out.println("Y = " + screenY);

        imageX = screenX;
        imageY = screenY;
        float delta = screenY - lasttouchY;

        camera.position.y += delta;

        lasttouchY = screenY;




        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    @Override
    public void show() {
        stage = new Stage(viewport, batch);;
        multiplexer = new InputMultiplexer();

        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(this);

        Gdx.input.setInputProcessor(multiplexer);

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        camera.position.y=
            MathUtils.clamp(camera.position.y,viewport.getWorldHeight()/2f,3500-viewport.getWorldHeight()/2f);


        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        // Draw the background over the entire virtual screen
        batch.draw(
            background,
            0,
            0,
            viewport.getWorldWidth(),
            viewport.getWorldHeight()
        );
    batch.draw(abc,imageX,imageY);
        batch.end();
        stage.act(delta);
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();
        background.dispose();
        abc.dispose();
    }
}
