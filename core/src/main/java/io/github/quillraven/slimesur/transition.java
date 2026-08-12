package io.github.quillraven.slimesur;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class transition implements Screen {
    GdxDEMOANDROIDGame game;
    SpriteBatch batch;
 BitmapFont fonter;
 Texture transi;
    float alpha = 0;
    float timer = 0;
        public transition( GdxDEMOANDROIDGame game){
            this.game=game;
            batch=new SpriteBatch();

            transi = new Texture("trasition.png");


        }

    @Override
    public void show() {
        FreeTypeFontGenerator generator=new FreeTypeFontGenerator(Gdx.files.internal("MOODERN.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter=new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size=60;
        fonter=generator.generateFont(parameter);
        generator.dispose();
    }

    @Override
    public void render(float delta) {
        batch.begin();
        timer+=delta;
   if(alpha<1f){
       alpha+=   delta/2f;

   }
   Gdx.gl.glClearColor(0.05f,0.05f,0.05f, 1);
   Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

   batch.setColor(.7f, .7f, .7f, alpha);
   batch.draw(transi,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

   fonter.setColor(1,1,1,alpha);
        // text
        fonter.draw(batch,
            "LESSON 1",
            Gdx.graphics.getWidth()/2f,
                Gdx.graphics.getHeight()/2f);
batch.end();
if(timer>3){
    game.setScreen(new QuizeTest(game));
}
    }

    @Override
    public void resize(int i, int i1) {

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
        batch.dispose();


        transi.dispose();
    }
}
