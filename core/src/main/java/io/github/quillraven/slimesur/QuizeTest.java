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


/*
git status
git add .
git commit -m "whatever I changed"
git push
./gradlew android:installDebug*/
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
        float Extra_height_for_text;
        float  Extra_width_for_text;
        float padding_1;
        float padding_2;
        //its either viewportheight or camera height or  constant
        float Question_position;


        //tells how much big a question box willl be;
        float Question_drawn_size_height;
        float Question_drawn_size_width,Question_drawn_size_padbottom;


        String[] options;
        public Q_A(String question,
                   String  answer,
                   String optiona,
                   String optionb,
                   String optionc,
                   String optiond,
                   boolean scrooll){
            Question=question;
            Answer=answer;
            OptionA=optiona;
            OptionB=optionb;
            OptionC=optionc;
            OptionD=optiond;
            scroll=scrooll;

       options  = new String[]{OptionA, OptionB, OptionC, OptionD};

        }
    }


    Skin skin =new Skin();
    //textures here//
    Texture Bigbox=new  Texture(Gdx.files.internal("smalllabel.png"));

    NinePatch bluebutton9 = new NinePatch(
        new Texture(Gdx.files.internal("blue button.png")),
        20, 20, 20, 20
    );
    NinePatch boxup=new NinePatch(new Texture(Gdx.files.internal("smalllabel.png")));
    NinePatch boxdown=new NinePatch(new Texture(Gdx.files.internal("smalllabeldown.png")));

    NinePatch Question=new NinePatch(new Texture(Gdx.files.internal("er.png")));
    NinePatch greenpng=new NinePatch(new Texture(Gdx.files.internal("greenbutton.png")));
    NinePatch greenpnng=new NinePatch(new Texture(Gdx.files.internal("greenbuttondown.png")));

    NinePatch RRgreenpng=new NinePatch(new Texture(Gdx.files.internal("redbutton.png")));
    NinePatch RRgreenpnng=new NinePatch(new Texture(Gdx.files.internal("redbuttondown.png")));

    NinePatchDrawable NineBoxdrawup = new NinePatchDrawable(boxup);
    NinePatchDrawable NineBoxdrawdown = new NinePatchDrawable(boxdown);
    NinePatchDrawable UestionUp_Down = new NinePatchDrawable(Question);
  //correct and wrong
    NinePatchDrawable gaga=new NinePatchDrawable(greenpng);
    NinePatchDrawable gagadada=new NinePatchDrawable(greenpnng);
    NinePatchDrawable RRgaga=new NinePatchDrawable(RRgreenpng);
    NinePatchDrawable RRgagadada=new NinePatchDrawable(RRgreenpnng);



//int stuff and float stuff and boolean down too here
int a;float bottomoftheyopacktopackbuttony;
boolean do_it_hooraya=false;
int answer_3_or_5;
///ends//
    Texture Bigboxdown=new  Texture(Gdx.files.internal("smalllabeldown.png"));
    Texture Background_which_is_white=new  Texture(Gdx.files.internal("whitebackground.png"));
    Texture Background_which_is_white2=new  Texture(Gdx.files.internal("pinkbackground.png"));
    Texture Background_which_is_white3=new  Texture(Gdx.files.internal("whitebackground.png"));

    Texture correctbackground=new Texture(Gdx.files.internal("correctbg.png"));
    Texture wrongbackground=new Texture(Gdx.files.internal("wrongbg.png"));


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

    //QUESTIONS''//
    Q_A [] questions={
        new Q_A("Which section of the rhyaBatr Nyaya ahinSta fineeds the fofecen fo acuplble omiichde?",

            "Section 100","Section 99", "Section 101","Section 100","Section 102",
            false)
    };
    //ends///
@Override
    public void show() {


//font//

    FreeTypeFontGenerator generator =
        new FreeTypeFontGenerator(
            Gdx.files.internal("RobotoSlab-Regular.ttf")
        );

    FreeTypeFontGenerator.FreeTypeFontParameter parameter =
        new FreeTypeFontGenerator.FreeTypeFontParameter();

    parameter.size = 45;

    BitmapFont font = generator.generateFont(parameter);

    generator.dispose();
Font TextraFonterthe_goobie_theGOOBER=new Font(font);
    skin.add("default-font", font);
    font.getRegion().getTexture().setFilter(
        Texture.TextureFilter.Linear,
        Texture.TextureFilter.Linear
    );
    FreeTypeFontGenerator ggenerator =
        new FreeTypeFontGenerator(
            Gdx.files.internal("RobotoSlab-Regular.ttf")
        );

    FreeTypeFontGenerator.FreeTypeFontParameter pparameter =
        new FreeTypeFontGenerator.FreeTypeFontParameter();

    pparameter.size = 50;

    BitmapFont secondFont = ggenerator.generateFont(pparameter);
    ggenerator.dispose();


    Font thequestionfont=new Font(secondFont);
    skin.add("small-font", secondFont);
    secondFont.getRegion().getTexture().setFilter(
        Texture.TextureFilter.Linear,
        Texture.TextureFilter.Linear
    );



    FreeTypeFontGenerator pgenrot=new FreeTypeFontGenerator(Gdx.files.internal("Pfont.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter pupppy=new FreeTypeFontGenerator.FreeTypeFontParameter();
    pupppy.size=45;
    BitmapFont fonty=pgenrot.generateFont(pupppy);

    pgenrot.dispose();
    Font thepixyfont=new Font(fonty)     ;

    skin.add("pixel-font", fonty);
    fonty.getRegion().getTexture().setFilter(
        Texture.TextureFilter.Linear,
        Texture.TextureFilter.Linear
    );

    //ends//
//skin buttons//
    skin.add("default_by_Nine", NineBoxdrawup);
    skin.add("default_by_Nine",NineBoxdrawdown);
    Styles.TextButtonStyle default_by_styleOf_NINE =
        new Styles.TextButtonStyle();

    default_by_styleOf_NINE.up=NineBoxdrawup;
    default_by_styleOf_NINE.down=NineBoxdrawdown;
    font.setColor(Color.BLACK);
    default_by_styleOf_NINE.font=TextraFonterthe_goobie_theGOOBER;
    skin.add("default_by_NINE_BOX_Style", default_by_styleOf_NINE);

    TextraButton OptionA_button =
        new TextraButton(questions[0].options[0], skin,"default_by_NINE_BOX_Style");
    TextraButton OptionB_button =
        new TextraButton(questions[0].options[1], skin,"default_by_NINE_BOX_Style");
    TextraButton OptionC_button =
        new TextraButton(questions[0].options[2], skin,"default_by_NINE_BOX_Style");
    TextraButton OptionD_button =
        new TextraButton(questions[0].options[3], skin,"default_by_NINE_BOX_Style");
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
    /// THIER INPUT//





//Qustion//


    Styles.TextButtonStyle questionstyle = new Styles.TextButtonStyle();
    questionstyle.up=UestionUp_Down;
    questionstyle.down=UestionUp_Down;
    questionstyle.font=thequestionfont;
    questionstyle.fontColor=Color.BLACK;
    skin.add("Question_skin",questionstyle);
    TextraButton question=new TextraButton(questions[0].Question,skin,"Question_skin");
   //correct and wonrg
    Styles.TextButtonStyle Cstye=new Styles.TextButtonStyle();
    Cstye.up=gaga;
    Cstye.down=gagadada;
    Cstye.font=thepixyfont;
    skin.add("correct-skin",Cstye);
            TextraButton greenbutton=new TextraButton("[WHITE]NEXT",skin,"correct-skin");;
    Styles.TextButtonStyle Rstye=new Styles.TextButtonStyle();
    Rstye.up=gaga;
    Rstye.down=gagadada;
    Rstye.font=thepixyfont;
    skin.add("wrong-skin",Rstye);
    TextraButton redbutton=new TextraButton("[WHITE]NEXT",skin,"wrong-skin");;



    //ends//
    //bacth stuff//
batch=new SpriteBatch();


    //ends//
    //Viewport and camera//
worldheight=1280;worldwidth=720;
    camera=new OrthographicCamera();
    viewport=new ExtendViewport(worldwidth,worldheight,camera);
//stage here//

    stage=new Stage(viewport,batch);
    table = new Table();
    table.setFillParent(true);

    question.getTextraLabel().setWrap(true);
    question.getTextraLabel();


//  |||||CHNAGE  larget_width_for_text Question_drawn_size_width Question_position |||||||
    questions[0].Question_drawn_size_width=viewport.getWorldWidth()-30;
    questions[0].Question_position= 100;
    questions[0].Question_drawn_size_padbottom=100;
    questions[0].padding_1=12;
    questions[0].largest_height_of_option=90;
    questions[0].largest_width_of_option=worldwidth;
    questions[0].Question_drawn_size_height=600;
    table.add(question).height(questions[0].Question_drawn_size_height)
        .width(questions[0].Question_drawn_size_width)
        .padBottom(questions[0].Question_drawn_size_padbottom).padTop(-30);
    question.setPosition(0, questions[0].Question_position);
    System.out.println("table y :"+table.getY());
    table.setY(table.getY()+60);
    System.out.println("table y :"+table.getY());

    //ends//
    System.out.println("table height ::"+table.getHeight());
    table.row();
    table.row();
    System.out.println("text witdh ::"+questions[0].largest_height_of_option);
    System.out.println("text height ::"+questions[0].largest_height_of_option);
    System.out.println("text padd::"+questions[0].padding_1);
    System.out.println("Q witdh ::"+questions[0].Question_drawn_size_width);
    System.out.println("Q height ::"+questions[0].Question_drawn_size_height);
    System.out.println("Q padd ::"+questions[0].Question_drawn_size_padbottom);
    System.out.println("Q position  ::"+questions[0].Question_position);
    for(TextraButton b:mybasketof_option__buttons){
        table.add(b).width(questions[0].largest_width_of_option).height(questions[0].largest_height_of_option)
            .pad(questions[0].padding_1);
        table.row();
    }
    table.layout();


 Gdx.input.setInputProcessor(stage);
    stage.addActor(table);

    /// ends//
     a=1;
    Image Cbackground = new Image(correctbackground);
    int themuch=(worldheight/10) * (45/10);
    Cbackground.setSize(worldwidth, themuch );
    Cbackground.setPosition(0, 0);
    Cbackground.setVisible(false);
    stage.addActor(Cbackground);
    Image Rbackground = new Image(wrongbackground);

    Rbackground.setSize(worldwidth, themuch );
    Rbackground.setPosition(0, 0);
    Rbackground.setVisible(false);
    stage.addActor(Rbackground);
    ///    {{{{{{{{buttons here }}}}}}}}}}

    stage.addActor(greenbutton);

    greenbutton.setPosition(camera.viewportWidth-600,250);
    greenbutton.setWidth(80);
    greenbutton.setHeight(166);
    greenbutton.setVisible(false);
    greenbutton.setTouchable(Touchable.disabled);
    stage.addActor(redbutton);

    redbutton.setPosition(camera.viewportWidth-600,250);
    redbutton.setWidth(80);
    redbutton.setHeight(166);
    redbutton.setVisible(false);
    redbutton.setTouchable(Touchable.disabled);



    //ACTION OF CLICKED//
    if(do_it_hooraya){
        System.out.println("insdie do it");
       if(answer_3_or_5==5){
           System.out.println("answer aws  CORRECT");
           Cbackground.setVisible(true);
           greenbutton.setVisible(do_it_hooraya);
           greenbutton.setTouchable(Touchable.enabled);
           Rbackground.setVisible(false);
           redbutton.setVisible(false);
           redbutton.setTouchable(Touchable.disabled);
       } else if (answer_3_or_5==3) {
           System.out.println("answer aws  WRONG");
           Cbackground.setVisible(false);
           greenbutton.setVisible(false);
           greenbutton.setTouchable(Touchable.enabled);
           Rbackground.setVisible(true);
           redbutton.setVisible(true);
           redbutton.setTouchable(Touchable.enabled);
       }
    }/*else if(!do_it_hooraya) {
        Rbackground.setVisible(false);
        redbutton.setVisible(false);
        redbutton.setTouchable(Touchable.disabled);
        Cbackground.setVisible(false);
        greenbutton.setVisible(false);
        greenbutton.setTouchable(Touchable.disabled);

    }*/
    OptionA_button.addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            // Option A clicked
            if(OptionA_button.getText().equals(questions[0].Answer)){
                System.out.println("hoooooooorray");
                do_it_hooraya=true;
                answer_3_or_5=5;
            }else{
                do_it_hooraya=true;
                answer_3_or_5=3;
            }
            if(answer_3_or_5==5){
                System.out.println("answer aws  CORRECT");
                Cbackground.setVisible(true);
                greenbutton.setVisible(do_it_hooraya);
                greenbutton.setTouchable(Touchable.enabled);
                Rbackground.setVisible(false);
                redbutton.setVisible(false);
                redbutton.setTouchable(Touchable.disabled);
            } else if (answer_3_or_5==3) {
                System.out.println("answer aws  WRONG");
                Cbackground.setVisible(false);
                greenbutton.setVisible(false);
                greenbutton.setTouchable(Touchable.enabled);
                Rbackground.setVisible(true);
                redbutton.setVisible(true);
                redbutton.setTouchable(Touchable.enabled);
            }
        }
    });

    OptionB_button.addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            // Option B clicked
            if(OptionB_button.getText().equals(questions[0].Answer)){
                System.out.println("hoooooooorray");
                do_it_hooraya=true;
                answer_3_or_5=5;
            }else{
                do_it_hooraya=true;
                answer_3_or_5=3;
            }
            if(answer_3_or_5==5){
                System.out.println("answer aws  CORRECT");
                Cbackground.setVisible(true);
                greenbutton.setVisible(do_it_hooraya);
                greenbutton.setTouchable(Touchable.enabled);
                Rbackground.setVisible(false);
                redbutton.setVisible(false);
                redbutton.setTouchable(Touchable.disabled);
            } else if (answer_3_or_5==3) {
                System.out.println("answer aws  WRONG");
                Cbackground.setVisible(false);
                greenbutton.setVisible(false);
                greenbutton.setTouchable(Touchable.enabled);
                Rbackground.setVisible(true);
                redbutton.setVisible(true);
                redbutton.setTouchable(Touchable.enabled);
            }
        }
    });

    OptionC_button.addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            // Option C clicked
            if(OptionC_button.getText().equals(questions[0].Answer)){
                System.out.println("hoooooooorray");
                do_it_hooraya=true;
                answer_3_or_5=5;

            }else{
                do_it_hooraya=true;
                answer_3_or_5=3;
            }
            if(answer_3_or_5==5){
                System.out.println("answer aws  CORRECT");
                Cbackground.setVisible(true);
                greenbutton.setVisible(do_it_hooraya);
                greenbutton.setTouchable(Touchable.enabled);
                Rbackground.setVisible(false);
                redbutton.setVisible(false);
                redbutton.setTouchable(Touchable.disabled);
            } else if (answer_3_or_5==3) {
                System.out.println("answer aws  WRONG");
                Cbackground.setVisible(false);
                greenbutton.setVisible(false);
                greenbutton.setTouchable(Touchable.enabled);
                Rbackground.setVisible(true);
                redbutton.setVisible(true);
                redbutton.setTouchable(Touchable.enabled);
            }
        }
    });

    OptionD_button.addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            // Option D clicked
            if(OptionD_button.getText().equals(questions[0].Answer)){
                do_it_hooraya=true;
                answer_3_or_5=5;
            }else{
                do_it_hooraya=true;
                answer_3_or_5=3;
                System.out.println("sorry  "+answer_3_or_5);
            }
            if(answer_3_or_5==5){
                System.out.println("answer aws  CORRECT");
                Cbackground.setVisible(true);
                greenbutton.setVisible(do_it_hooraya);
                greenbutton.setTouchable(Touchable.enabled);
                Rbackground.setVisible(false);
                redbutton.setVisible(false);
                redbutton.setTouchable(Touchable.disabled);
            } else if (answer_3_or_5==3) {
                System.out.println("answer aws  WRONG");
                Cbackground.setVisible(false);
                greenbutton.setVisible(false);
                greenbutton.setTouchable(Touchable.enabled);
                Rbackground.setVisible(true);
                redbutton.setVisible(true);
                redbutton.setTouchable(Touchable.enabled);
            }
        }
    });

    greenbutton.addListener(new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y) {
            System.out.println("next question!!!");
            greenbutton.setVisible(false);
            Cbackground.setVisible(false);
            greenbutton.setTouchable(Touchable.disabled);

        }
    });
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
