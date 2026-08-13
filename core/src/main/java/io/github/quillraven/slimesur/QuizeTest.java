package io.github.quillraven.slimesur;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.Arrays;
import java.util.Collections;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.*;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;

import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
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

        String[] options;
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
       options  = new String[]{OptionA, OptionB, OptionC, OptionD};

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
    Texture bluebuton=new Texture(Gdx.files.internal("blue button.png"));
    NinePatch bluebutton9 = new NinePatch(
        new Texture(Gdx.files.internal("blue button.png")),
        20, 20, 20, 20
    );
int a;
    Texture Bigboxdown=new  Texture(Gdx.files.internal("smalllabeldown.png"));
    Texture Background_which_is_white=new  Texture(Gdx.files.internal("whitebackground.png"));
    Texture Background_which_is_white2=new  Texture(Gdx.files.internal("pinkbackground.png"));
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

    parameter.size = 109;

    BitmapFont font = generator.generateFont(parameter);

    generator.dispose();
Font TextraFonterthe_goobie_theGOOBER=new Font(font);
    skin.add("default-font", font);
    font.getRegion().getTexture().setFilter(
        Texture.TextureFilter.Linear,
        Texture.TextureFilter.Linear
    );
    //ends//
//skin buttons//

    Styles.TextButtonStyle buttonStyle = new Styles.TextButtonStyle();
    buttonStyle.up = new TextureRegionDrawable(
        new TextureRegion(Bigbox)
    );

    buttonStyle.down = new TextureRegionDrawable(
        new TextureRegion(Bigboxdown)
    );
    Styles.TextButtonStyle bluebuttonStyle = new Styles.TextButtonStyle();
    bluebuttonStyle.up = new TextureRegionDrawable(
        new TextureRegion(bluebuton)
    );

    bluebuttonStyle.down = new TextureRegionDrawable(
        new TextureRegion(bluebuton)
    );

    skin.add("default", buttonStyle);
    skin.add("bluer",bluebuttonStyle);
    bluebuttonStyle.font=TextraFonterthe_goobie_theGOOBER;
buttonStyle.font=TextraFonterthe_goobie_theGOOBER;
    TextraButton OptionA_button =
        new TextraButton(questions[0].options[0], skin);
    TextraButton OptionB_button =
        new TextraButton(questions[0].options[1], skin);
    TextraButton OptionC_button =
        new TextraButton(questions[0].options[2], skin);
    TextraButton OptionD_button =
        new TextraButton(questions[0].options[3], skin);
    TextraButton[] mybasketof_option__buttons = {

        OptionA_button,OptionB_button,OptionC_button,OptionD_button,
    };
    for (TextraButton button : mybasketof_option__buttons) {
        button.setText("[BLACK]"+button.getText());
    }
    Collections.shuffle(Arrays.asList(mybasketof_option__buttons));

    System.out.println("BEFORE:");

    for (TextraButton button : mybasketof_option__buttons) {
        System.out.println(button.getText());
    }

    Collections.shuffle(Arrays.asList(mybasketof_option__buttons));

    System.out.println("AFTER:");

    for (TextraButton button : mybasketof_option__buttons) {
        System.out.println(button.getText());
    }
TextraButton bb=new TextraButton("Frustration", skin,"bluer");

    NinePatchDrawable ninedraw = new NinePatchDrawable(bluebutton9);

    skin.add("answer", ninedraw);
    TextButton.TextButtonStyle style =
        new TextButton.TextButtonStyle();

    style.up=ninedraw;
    style.down=ninedraw;
    style.font=font;
    skin.add("answerStyle", style);

    skin.add("answerStyle", style);
    TextButton button9 =
        new TextButton("Frustration", skin, "answerStyle");

    //ends//
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

for(TextraButton b:mybasketof_option__buttons){
    table.add(b).width(worldwidth).height(200).pad(12);
    table.row();
}
    table.add(button9);
table.row();
table.add(bb);
Gdx.input.setInputProcessor(stage);
    stage.addActor(table);

    /// ends//
     a=1;
    }


    @Override
    public void render(float delta) {
ScreenUtils.clear(Color.GREEN);
viewport.apply();
batch.setProjectionMatrix(camera.combined);
batch.begin();
batch.draw(Background_which_is_white,0,0,worldwidth,worldheight);
batch.draw(Background_which_is_white2,0,worldheight,worldwidth,worldheight);



//in scase to print smth
        while(a>0){
            System.out.println(Background_which_is_white.getHeight()+","+Background_which_is_white.getDepth());
            System.out.println("pink::"+Background_which_is_white2.getHeight());
            a--;
        }
        //
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
