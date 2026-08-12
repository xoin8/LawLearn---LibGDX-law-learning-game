package io.github.quillraven.slimesur;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.Arrays;
import java.util.Collections;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Null;
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
import com.github.tommyettinger.textra.TextraButton;
import com.github.tommyettinger.textra.TypingAdapter;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.w3c.dom.Text;
import com.github.tommyettinger.textra.TypingLabel;
import sun.awt.X11.XEvent;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.github.tommyettinger.textra.Styles;
import com.github.tommyettinger.textra.Font;

import com.badlogic.gdx.Screen;
//

class QuizeTest implements Screen,InputProcessor {

    GdxDEMOANDROIDGame game;
    public  QuizeTest(GdxDEMOANDROIDGame game) {
        this.game=game;
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
        return false;
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
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    /// DEFINE EVERYTHING HERE///
    class Q_A {
        String Question;
        String  Answer;
        String OptionA;
        String OptionB;
        String OptionC;
        String OptionD;
        int largest_height_of_option;
        int largest_width_of_option;
        boolean scroll;
        int Extra_height_for_text;
        int  Extra_width_for_text;
        int padding_1;
        int padding_2;
        String[] options= {OptionA, OptionB, OptionC, OptionD};

        public Q_A(String question,
                   String  answer,
                   String optiona,
                   String optionb,
                   String optionc,
                   String optiond,
                   boolean scrooll,
                   int extra_height_for_text,
                   int extra_width_for_text){
            Question=question;
            Answer=answer;
            OptionA=optiona;
            OptionB=optionb;
            OptionC=optionc;
            OptionD=optiond;
            scroll=scrooll;
            Extra_height_for_text=extra_height_for_text;
            Extra_width_for_text=extra_width_for_text;

        }
    }
Q_A [] questions={
    new Q_A("Which section of the Bhartiya Nyaya Sanhita defines the offence of culpable homicide?",

        "Section 100","Section 99", "Section 101","Section 100","Section 102",
        false,100,100)
    };

    Skin skin =new Skin();
    //textures here//
    Texture Bigbox=new  Texture(Gdx.files.internal("smalllabel.png"));
    Texture Bigboxdown=new  Texture(Gdx.files.internal("smalllabeldown.png"));
    Texture Background_which_is_white=new  Texture(Gdx.files.internal("whitebackground.png"));
    Texture Background_which_is_white2=new  Texture(Gdx.files.internal("whitebackground.png"));
    Texture Background_which_is_white3=new  Texture(Gdx.files.internal("whitebackground.png"));

    /// ends//
int worldheight,worldwidth;
    ///   ends  ///
//table and stage///
    private Stage stage;
    private Table table;
    private OrthographicCamera camera;
    private  ExtendViewport viewport;
    private SpriteBatch batch;


    ///ende///
@Override
    public void show() {


//font//
    FreeTypeFontGenerator generator =
        new FreeTypeFontGenerator(
            Gdx.files.internal("RobotoSlab-Regular.ttf")
        );

    FreeTypeFontGenerator.FreeTypeFontParameter parameter =
        new FreeTypeFontGenerator.FreeTypeFontParameter();

    parameter.size = 32;

    BitmapFont font = generator.generateFont(parameter);

    generator.dispose();
Font TextraFonterthe_goobie_theGOOBER=new Font(font);
    skin.add("default-font", font);
    //ends//
//skin buttons//
    //this was our previous code//
    /*skin.add("buttonup",new  TextureRegionDrawable(new TextureRegion(Bigbox)));
      skin.add("buttondown",new TextureRegionDrawable(new TextureRegion(Bigboxdown)));
   Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
   buttonStyle.up=skin.getDrawable("buttonup");
   buttonStyle.down=skin.getDrawable("buttondown");
   skin.add("buttonSTLYE",buttonStyle);
   skin.add("default", buttonStyle,TextButton.TextButtonStyle.class);*/

    //Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
//TextButton.TextButtonStyle buttonStyle=new TextButton.TextButtonStyle();
    Styles.TextButtonStyle buttonStyle = new Styles.TextButtonStyle();
    buttonStyle.up = new TextureRegionDrawable(
        new TextureRegion(Bigbox)
    );

    buttonStyle.down = new TextureRegionDrawable(
        new TextureRegion(Bigboxdown)
    );

    skin.add("default", buttonStyle);
buttonStyle.font=TextraFonterthe_goobie_theGOOBER;
    TextraButton OptionA_button =
        new TextraButton(questions[0].options[0], skin);
    TextraButton OptionB_button =
        new TextraButton(questions[0].options[1], skin);
    TextraButton OptionC_button =
        new TextraButton(questions[0].options[2], skin);
    TextraButton OptionD_button =
        new TextraButton(questions[0].options[3], skin);
    TextraButton[] optins_buttons = {

        OptionA_button,OptionB_button,OptionC_button,OptionD_button,
    };
    Collections.shuffle(Arrays.asList(optins_buttons));

    //bacth stuff//
batch=new SpriteBatch();


    //ends//
    //Viewport and camera//
worldheight=1280;worldwidth=720;
    camera=new OrthographicCamera();
    viewport=new ExtendViewport(worldwidth,worldheight,camera);

    //ends//
//stage here//

    stage=new Stage(viewport,batch);
    table = new Table();
    table.setFillParent(true);

for(TextraButton b:optins_buttons){
    table.add(b).width(500).height(500).pad(500);
    table.row();
}
Gdx.input.setInputProcessor(stage);
    stage.addActor(table);

    /// ends///


    }


    @Override
    public void render(float delta) {
ScreenUtils.clear(Color.GREEN);
viewport.apply();
batch.setProjectionMatrix(camera.combined);
batch.begin();
batch.draw(Background_which_is_white,0,0,worldwidth,worldheight);

batch.end();
stage.act(delta);
stage.draw();

    }

    @Override
    public void resize(int width, int height) {
stage.getViewport().update(width, height, true);
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
Bigbox.dispose();Bigboxdown.dispose();
stage.dispose();
skin.dispose();
batch.dispose();Background_which_is_white.dispose();
        Background_which_is_white2.dispose();Background_which_is_white3.dispose();
    }
}
