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

public class lesson0 implements Screen,InputProcessor {
    GdxDEMOANDROIDGame game;
     Page p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    SpriteBatch batch; boolean isTrue_false_2=true; boolean tapHherebutton_boolean=false;
    boolean nowapplytouch=false;boolean illustrations=false;
    boolean iouo=false;
    BitmapFont font,font_2; int mo=0;
    Texture higurumaimage,BackgroundB,Backgroud,textlineforwheretheyshouldstart; Viewport extendViewport;
    int a,b,onlyonetimer; Stage stage; float maxCameraY,minCameraY;
     TextureRegion TextureBACKGROUND,TextureBACKGROUND2;
     float thefade=0;float APPLE=0;
    float velocityY;
    float damping ;

    Texture bBoxofdialouge;  float alphi,alphi2; Table root_thetable;
    Texture okbuttonup ,okbuttondown;
float timers; float resolu;
    int numerber=0;boolean startthelesson=false;
TypingLabel typingLabel,typinglabel_for_section, animationLabel,lastwordtypinglabel,typinglabel_illustration;        ; Page[] pages;
    ImageButton tape_here_button_button,tape_here_button_button_2,ok_up_down_button,isslustrationbutton,simplfybutton,blackbutton;
    boolean start_the_section=false;
    boolean nowstopcoming=false;
Texture higupoint =    new Texture(Gdx.files.internal("pointhigu.png"));
Texture higubheind =    new Texture(Gdx.files.internal("behindposehigu.png"));
Texture simplfyup,simplfydown;

    OrthographicCamera camera;
    InputMultiplexer multiplexer = new InputMultiplexer();


    boolean autoCamera = false;
    boolean manualCamera = false;

    float targetY;
boolean lastdraw=false;
    float lastTouchY;  float worldBottom = -Gdx.graphics.getHeight();
    float worldTop    =  Gdx.graphics.getHeight();

   ExtendViewport viewport;
    float halfView;


    public lesson0(GdxDEMOANDROIDGame game){

        this.game = game;
        bBoxofdialouge=new Texture(Gdx.files.internal("box.png"));
        ;
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
        lastTouchY=screenY;
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
        if (!manualCamera)
            return false;

       /* float deltaY = lastTouchY - screenY;

        camera.translate(0, deltaY);
        camera.position.y = MathUtils.clamp(
            camera.position.y,
            minCameraY,
            maxCameraY
        );
*/
        camera.update();

        lastTouchY = screenY;

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

    public class Page {


        Texture higurumaImages;
        String dialouge;

        float extraHeight = 0f;
        float extraWidth=0f;   float extratextheight=0f ;float extratextwidth=0f;

        public Page(Texture higurumaImages) {

            this.higurumaImages = higurumaImages;

        }
    }
public class Section{
ArrayList<String> Sentence_Explain=new ArrayList<>();
       float extra_section_text_height,extra_section_text_width;
}
    boolean true_false_1=false;
    @Override
    public void show() {
        camera = new OrthographicCamera();

          higurumaimage=game.higurumaimage;
        textlineforwheretheyshouldstart=new Texture(Gdx.files.internal("textlineforwheretheyshouldstart.png"));
         batch=new SpriteBatch();;
        viewport = new ExtendViewport(1075, 2000, camera);
        halfView=  viewport.getWorldHeight() / 2f;
  root_thetable=new Table();
root_thetable.setFillParent(true);
        stage=new Stage(viewport,batch);
        Gdx.input.setInputProcessor(stage);

        // Camera starts at the normal position
     /*   camera.position.set(
            viewport.getWorldWidth() / 2f,
            viewport.getWorldHeight() / 2f,
            0);

camera.position.y=
    MathUtils.clamp(camera.position.y,viewport.getWorldHeight()/2f,3500-viewport.getWorldHeight()/2f);
       */



        camera.position.y = Math.max(
            worldBottom + halfView,
            Math.min(camera.position.y,
                worldTop - halfView)
        );

        camera.update();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(this);  // Camera dragging
      // Buttons first
        Gdx.input.setInputProcessor(multiplexer);
        camera.update();
        minCameraY = viewport.getWorldHeight()/2f;

stage.addActor(root_thetable);
        Backgroud=new Texture(Gdx.files.internal("lawbackground.png"));
        BackgroundB=new Texture(Gdx.files.internal("lawbackground.png"));
 p1=new Page(higurumaimage);p2=new Page(higupoint);
 p3=new Page(higupoint);
 p4=new Page(higubheind);
 p5=new Page(higurumaimage);
        p6=new Page(higupoint);
        p7=new Page(higurumaimage);
        p8=new Page(higubheind);
 //text//

 p3.extratextheight=-65;
        p3.extratextwidth=0f;
 p1.dialouge="[BLACK]{WAIT=1}{EVENT=HELLO}Hello Welcome,{WAIT=1}";
 p2.dialouge="[BLACK]{SPEED=7}Welcomen to LawLear,where you can learn laws for free {WAIT=1}";
p3.dialouge="[BLACK]{SPEED=7}{WAIT=0.1}whether you are lay man , a law student or a salaray man\n its for everyone{WAIT=1}";
p8.dialouge="[BLACK]the best way to lern anything is to take pratice test...ye once your done reading this all examples click test button\ndont worry it will ba lot fun";
p4.dialouge="[BLACK]{SPEED=7}I'm Higuruma Hirome ,a defence attorney at the Iwata High Court Japan\n.I'll be your guide and I'll explain everything as simply as I can";
        p2.extratextheight=-30f;
        p4.extratextheight=-150f;
        p5.dialouge="[BLACK]{WAIT=1}Dont worry i'll explain you everything{EVENT=bcome}{WAIT=1}";
        p6.dialouge="[BLACK]{SPEED=7}{WAIT=2}Lets first understand all the hard legal wording";
        p7.dialouge="[BLACK]{SPEED=7}Click the explain button to understand the text once you have read  it urself{EVENT=okbutton}";
        p6.extratextheight=p5.extratextheight;
        p6.extratextwidth=p5.extratextwidth;
        p7.extratextheight=p6.extratextheight;
        p7.extratextwidth=p6.extratextwidth;
//height//
p3.extraHeight=45;
p3.extraWidth=200;
p4.extraWidth=200;
p4.extraHeight=100;
        p2.extraHeight=40;p2.extraWidth=200f;
        /// /
         pages=new Page[]{p1,p2,p3,p4,p5,p6,p7};

        //Section code//
        Section section100=new Section();
        section100.Sentence_Explain.add("{WAIT=4}[BLACK]{SPEED=7}Section 100 -- Culpable Homicide\n\nDefinition- \nWhosoever causes death by doing an act with an intention of causing death or with intention of causing such bodily injury as is likely to cause death or with the knowledge that he is likely by such act tocause death ,commits the offence of CULPABLE HOMICIDE{EVENT=gooner}{EVENT=bcome}{WAIT 1}");
        section100.Sentence_Explain.add("[BLACK]{SPEED=7}Section 100 -- {HIDE}Culpable Homicide\n\nDefinition{ENDHIDE}- \nWhosoever causes death by doing an act with an intention of causing death or with intention of causing such {WAIT 1}[red][?neon]bodily injury as is likely to cause death or with the knowledge[?] [BLACK]that he is likely by such act tocause death ,commits the offence of CULPABLE HOMICIDE{EVENT=re}");
        section100.Sentence_Explain.add("{HIDE}{SPEED=8}[BLACK]Illustrations\n\n" +

            "(a) A lays sticks and turf over a pit, with the intention of thereby causing death, or with the knowledge that death is likely to be thereby caused.\n" +
            "Z, believing the ground to be firm, treads on it, falls in and is killed.\n" +
            "A has committed the offence of culpable homicide.\n\n" +

            "(b) A knows Z to be behind a bush. B does not know it.\n" +
            "A, intending to cause, or knowing it to be likely to cause Z's death, induces B to fire at the bush.\n" +
            "B fires and kills Z. Here B may be guilty of no offence; but A has committed the offence of culpable homicide.\n\n" +

            "(c) A, by shooting at a fowl with intent to kill and steal it, kills B, who is behind a bush; A not knowing that he was there.\n" +
            "Here, although A was doing an unlawful act, he was not guilty of culpable homicide, as he did not intend to kill B, or to cause death by doing an act that he knew was likely to cause death.\n\n" +

            "Explanation 1\n" +
            "A person who causes bodily injury to another who is labouring under a disorder, disease or bodily infirmity, and thereby accelerates the death of that other, shall be deemed to have caused his death.\n\n" +

            "Explanation 2\n" +
            "Where death is caused by bodily injury, the person who causes such bodily injury shall be deemed to have caused the death, although by resorting to proper remedies and skilful treatment the death might have been prevented.\n\n" +

            "Explanation 3\n" +
            "The causing of the death of a child in the mother's womb is not homicide.\n" +
            "But it may amount to culpable homicide to cause the death of a living child, if any part of that child has been brought forth, though the child may not have breathed or been completely born.\n\n" +

            "Note: This Section corresponds to Sec.299 of I.P.C., 1860.{ENDHIDE}");
        //
        TextureBACKGROUND= new TextureRegion(Backgroud);
        TextureBACKGROUND2=new TextureRegion(BackgroundB);

        FreeTypeFontGenerator generator =
            new FreeTypeFontGenerator(Gdx.files.internal("MOODERN.ttf"));
        FreeTypeFontGenerator generator_2=new FreeTypeFontGenerator(Gdx.files.internal("Roboto-Light.ttf"));
numerber=0;
        onlyonetimer=100;
        FreeTypeFontGenerator.FreeTypeFontParameter parameter =
            new FreeTypeFontGenerator.FreeTypeFontParameter();
         timers=0;
        parameter.size = 60;

        FreeTypeFontGenerator.FreeTypeFontParameter parameter_2 =
            new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter_2.size=60;
        font = generator.generateFont(parameter);
        font_2 = generator.generateFont(parameter_2);
        Font fonter=new Font(generator.generateFont(parameter));
        Font fonter_2=new Font(generator_2.generateFont(parameter_2));
        fonter.PACKED_NOTE_COLOR = Color.CLEAR.toFloatBits();
        fonter_2.PACKED_NOTE_COLOR = Color.CLEAR.toFloatBits();
        typingLabel=new TypingLabel(pages[numerber].dialouge,fonter);
        typinglabel_for_section=new TypingLabel(section100.Sentence_Explain.get(0),fonter_2);
        typingLabel.setWrap(true);

        typinglabel_for_section.setWidth(Gdx.graphics.getWidth()-20f); // Example width
        typingLabel.setFont(fonter);
        typinglabel_for_section.setWrap(true);
        typinglabel_for_section.setFont(fonter_2);
        typingLabel.setSize(Gdx.graphics.getWidth()-40,300);/*
        typinglabel_for_section.setSize(Gdx.graphics.getWidth()-40,Gdx.graphics.getHeight()/2f);
        */typingLabel.setPosition(20, 200);
        typinglabel_for_section.setVisible(false);
        typinglabel_for_section.pause();
        animationLabel = new TypingLabel(section100.Sentence_Explain.get(1),fonter_2);
//typing for illustration//
        typinglabel_illustration=new TypingLabel("[BLACK]hi there how ru/nloremfjdlflffjlsfdslkfffffffdlfjdfjlfjljfsf "+"ffhllffffffffffffffffffffl;dkfdhf;ff;oiffhfsdfl\nxzbc,ccnxncxmnmn385",fonter_2);
        typinglabel_illustration.setWrap(true);
        typinglabel_illustration.setFont(fonter_2);

        typinglabel_illustration.setWidth(Gdx.graphics.getWidth()-20f);
        typinglabel_illustration.setPosition(20,-typinglabel_for_section.getY()+20);
        typinglabel_illustration.setVisible(false);
        typinglabel_illustration.pause();
        stage.addActor(typinglabel_illustration);

//
         //lastword//
        lastwordtypinglabel=new TypingLabel(p8.dialouge,fonter);
        lastwordtypinglabel.setWrap(true);
        lastwordtypinglabel.setWidth(Gdx.graphics.getWidth()-20f);
        lastwordtypinglabel.setPosition(20,viewport.getWorldHeight()+10);
        lastwordtypinglabel.setVisible(false);
        stage.addActor(lastwordtypinglabel);


//
        animationLabel.setWidth(Gdx.graphics.getWidth()-20f);
        animationLabel.setPosition(20,Gdx.graphics.getHeight()/2f+500);


        animationLabel.setWrap(true);
        animationLabel.setVisible(false);
animationLabel.pause();
        stage.addActor(animationLabel);
        float worldheight=TextureBACKGROUND.getRegionHeight()+TextureBACKGROUND2.getRegionHeight();

        maxCameraY=worldheight-viewport.getWorldHeight()/2f;
        minCameraY = viewport.getWorldHeight() / 2f;
        okbuttonup=new Texture("buttonblack.png");  okbuttondown=new Texture("buttonblack.png");



        TextureRegionDrawable honeyupDrawable =
            new TextureRegionDrawable(
                new TextureRegion(okbuttonup));

        TextureRegionDrawable honeydownDrawable =
            new TextureRegionDrawable(
                new TextureRegion(okbuttondown));


        Button.ButtonStyle ookstyle = new Button.ButtonStyle();

        ookstyle.up = honeyupDrawable;
        ookstyle.down = honeydownDrawable;
        ImageButton.ImageButtonStyle okstlye =
            new ImageButton.ImageButtonStyle();

        okstlye.up = honeyupDrawable;
         okstlye.down = honeydownDrawable;
        ok_up_down_button=new ImageButton(okstlye);
      ;isslustrationbutton=new ImageButton(okstlye);
        ok_up_down_button.setVisible(false);
        ok_up_down_button.setTouchable(Touchable.disabled);
        ok_up_down_button.setSize(450f, 250f);

        isslustrationbutton.setVisible(true);
        isslustrationbutton.setTouchable(Touchable.enabled);
        isslustrationbutton.setSize(450f, 250f);
        //i removed negative sign of it at y position to check
        isslustrationbutton.setPosition(200,(viewport.getWorldHeight()/2f-(100)));
        ok_up_down_button.setPosition(Gdx.graphics.getWidth()/2f,Gdx.graphics.getHeight()/2f);

        //simplfy button//
        simplfyup= new Texture("nowhiteS.png");
        simplfydown=new Texture("nowhiteSdown.png");

        TextureRegionDrawable simplyfup=new TextureRegionDrawable(new TextureRegion(simplfyup));
        TextureRegionDrawable simplydown=new TextureRegionDrawable(new  TextureRegion(simplfydown));
        ImageButton.ImageButtonStyle Simplfybutton =
            new ImageButton.ImageButtonStyle();

        Simplfybutton.up = simplyfup;
        Simplfybutton.down = simplydown;
        simplfybutton=new ImageButton(Simplfybutton);
        simplfybutton.setTouchable(Touchable.disabled);

        simplfybutton.setSize(450f, 250f);
        simplfybutton.setPosition(viewport.getWorldWidth()/2f,-viewport.getWorldHeight()/5f);
//font button//
        Button okButton = new Button(ookstyle);

        Label label = new Label("Continue", new Label.LabelStyle(font_2, Color.WHITE));

okButton.add(label).center();
        okButton.setBounds(200, 600, 800, 700);
okButton.padTop(130).padRight(90);

        stage.addActor(ok_up_down_button);
        stage.addActor(isslustrationbutton);
        stage.addActor(simplfybutton);
        stage.addActor(okButton);
        okButton.setVisible(false);
typingLabel.setTypingListener(new TypingAdapter(){
    @Override
    public void event(String event) {
if(event.equals("start_it")){
    start_the_section=true;
    typinglabel_for_section.setVisible(true);

    typinglabel_for_section.setPosition(20,Gdx.graphics.getHeight()/2f+500);
    typinglabel_for_section.resume();
    typinglabel_for_section.restart();
}
if(event.equals("HELLO")){
    tape_here_button_button.setVisible(false);tape_here_button_button.setTouchable(Touchable.disabled);
}
if(event.equals("okbutton")){
    ok_up_down_button.setVisible(true);
    ok_up_down_button.setTouchable(Touchable.enabled);
}
        if(event.equals("camera")){
/*
            cameraEnabled = true;


            targetCameraY =
                typingLabel.getY()
                    + typingLabel.getHeight()/2f;
            movingCamera = true;*/
            targetY=typingLabel.getY()+typingLabel.getHeight()/2f;
            autoCamera=true;
            manualCamera=false;

        }

        if(event.equals("bcome")){

            Actions.sequence(
                Actions.run(()->{
                    tapHherebutton_boolean=true;




                })
            );

        }
        if(event.equals("showhigu")){
                    isslustrationbutton.setVisible(true);
                    isslustrationbutton.setTouchable(Touchable.enabled);
        }
    }
@Override
    public void end(){

    if(numerber>3){
        tape_here_button_button.setVisible(false);
        tape_here_button_button.setTouchable(Touchable.disabled);
/*

        tape_here_button_button_2.setVisible(false);
        tape_here_button_button_2.setTouchable(Touchable.disabled);
*/

    }else{
        tape_here_button_button.setVisible(true);
        tape_here_button_button.setTouchable(Touchable.enabled);
/*
        tape_here_button_button_2.setVisible(false);
        tape_here_button_button_2.setTouchable(Touchable.disabled);
*/

    }
    if(tapHherebutton_boolean){
        if(nowstopcoming){

            tape_here_button_button_2.setVisible(false);
            tape_here_button_button_2.setTouchable(Touchable.disabled);
        }else{

            tape_here_button_button_2.setVisible(true);
            tape_here_button_button_2.setTouchable(Touchable.enabled);
        }
    }
}
});
typinglabel_for_section.setTypingListener(new TypingAdapter(){
    public void event(String event) {

        if(event.equals("gooner")){


        typinglabel_for_section.addAction(
            Actions.sequence(
                    Actions.delay(2f),
                Actions.run(()->{
                    true_false_1=true;
                    typingLabel.resume();
                    typingLabel.restart();
 if(mo>2){
     mo=0;
 }
                    typingLabel.setText(pages[4+mo].dialouge);
                    typingLabel.setPosition(20+pages[4+mo].extratextwidth,200+pages[mo+4].extratextheight);
                    typingLabel.restart();
                }),Actions.delay(1f),Actions.run(()->{
                    isTrue_false_2=true;

                    tapHherebutton_boolean = true;

//                    ;
                })
        )
        );
        }

        else{

            true_false_1=false;
        }

        if(event.equals("bcome")) {
            Actions.sequence(
                Actions.run(() -> {

                        Actions.delay(3f);
                        Actions.run(() -> {
                            tapHherebutton_boolean = true;

                        });
                    }
                ));
        };


    }


@Override
    public void end(){
}

});
animationLabel.setTypingListener(new TypingAdapter(){
    @Override
    public void event(String event) {
        if(event.equals("re")){

            typingLabel.resume();
            typingLabel.setVisible(true);
            typingLabel.setWidth(Gdx.graphics.getWidth()-20f);
            p4.dialouge="[BLACK]{WAIT 2}{SPEED=7} bodily injured as is likely- bodily means very grave or bad injury of the body , and AS IS LIKEY means which is likely{EVENT=camera}\n\n In simple words-" +
                "whoever kills someone by his action with an intention of death or wit intention{EVENT=camera} of giving such a severe wound knowing or not knowing that it will cause  death of the victim commits the crime of \nCulpable Homicide{EVENT=showhigu}";
            typingLabel.setText(p4.dialouge);
            typingLabel.restart();
        }
    }
});

typinglabel_illustration.setTypingListener(new TypingAdapter(){
    public void end(){
        System.out.println("inside illus typing ");
        simplfybutton.setVisible(true);
        lastdraw=true;
        simplfybutton.setTouchable(Touchable.enabled);
        System.out.println("button f simply is::"+simplfybutton.isVisible());
        lastwordtypinglabel.setVisible(false);;
        lastwordtypinglabel.restart();
        lastwordtypinglabel.setTouchable(Touchable.disabled);
    }
});

        Texture tap_here_button=new Texture("taphere.png");
        TextureRegionDrawable taphere_textureregion=new TextureRegionDrawable(new TextureRegion(tap_here_button));
ImageButton.ImageButtonStyle styliah=new ImageButton.ImageButtonStyle();
styliah.up=taphere_textureregion;
         tape_here_button_button=new ImageButton(styliah);
        tape_here_button_button.setSize(100f,100f);
        tape_here_button_button.setPosition(Gdx.graphics.getWidth()-100,100);
        stage.addActor(typingLabel);stage.addActor(typinglabel_for_section);


        tape_here_button_button_2=new ImageButton(styliah);
        tape_here_button_button_2.setSize(100f,100f);
        tape_here_button_button_2.setPosition(Gdx.graphics.getWidth()-100,100);

        stage.addActor(tape_here_button_button_2);

        tape_here_button_button_2.setVisible(false);
        tape_here_button_button_2.setTouchable(Touchable.disabled);

        generator.dispose();

        stage.addActor(typingLabel);
        tape_here_button_button.setVisible(false);tape_here_button_button.setTouchable(Touchable.disabled);
        stage.addAction(
            Actions.sequence(
                Actions.delay(2f),
                Actions.run(()->{

                    tape_here_button_button.setVisible(false);tape_here_button_button.setTouchable(Touchable.disabled);
                    stage.addActor(tape_here_button_button);
                })
            )
        );
        tape_here_button_button_2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                /*p5.higurumaImages=higubheind;*/

                if(mo<2){
                    if(nowstopcoming){

                        tape_here_button_button_2.setTouchable(Touchable.disabled);
                        tape_here_button_button.setVisible(false);
                        typingLabel.setVisible(false);
                    }
                    else{
                        mo++;
                    }

                }else{
                    mo=0;

                    typingLabel.pause();
                    tape_here_button_button_2.setTouchable(Touchable.disabled);
                    tape_here_button_button.setVisible(false);
                    typingLabel.setVisible(false);
                    nowstopcoming=true;

                    isTrue_false_2=false;
                    true_false_1=false;

                }
                typingLabel.setText(pages[4+mo].dialouge);
                typingLabel.setPosition(20+pages[4+mo].extratextwidth,200+pages[mo+4].extratextheight);
                typingLabel.restart();

                            tape_here_button_button_2.setVisible(false);
                            tape_here_button_button_2.setTouchable(Touchable.disabled);
            }
        });

        tape_here_button_button.addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {

            if(numerber>2){

                numerber++;
                tape_here_button_button.setVisible(false);
                                       tape_here_button_button.setTouchable(Touchable.disabled);
                isTrue_false_2=false; TextureBACKGROUND.getTexture().dispose();
                                         Backgroud = new Texture(Gdx.files.internal("whitebackground.png"));
                TextureBACKGROUND = new TextureRegion(Backgroud);
                startthelesson=true;

                typingLabel.setText("[BLACK]{WAIT 1}Criminal Case{WAIT 2}");
                typingLabel.setPosition(Gdx.graphics.getWidth()/2f+-100,Gdx.graphics.getHeight()/2f);
                typingLabel.restart();

                typingLabel.setPosition(Gdx.graphics.getWidth()/2f+-100,Gdx.graphics.getHeight()/2f);

                typingLabel.addAction(
                    Actions.sequence(Actions.delay(5f),
                        Actions.run(()->{
                            typingLabel.setText("[RED]SECTION 100{WAIT=1}{EVENT=start_it}");
                            typingLabel.restart();

                        }),
                        Actions.delay(1f),
                        Actions.moveTo(Gdx.graphics.getWidth()/2f-50,Gdx.graphics.getHeight()-300,2f, Interpolation.linear))
                );

                tape_here_button_button.setVisible(false);
                tape_here_button_button.setTouchable(Touchable.disabled);
                if(start_the_section){
                    typinglabel_for_section.restart();




                }
            //    System.out.println("the last part should be false::"+tape_here_button_button.isDisabled());

            }else{

                numerber++;
            //    System.out.println("numerber after ++ is::"+numerber);
                typingLabel.setText(pages[numerber].dialouge);
                typingLabel.setPosition(20+pages[numerber].extratextwidth,200+pages[numerber].extratextheight);
                typingLabel.restart();

                ;
                tape_here_button_button.setVisible(false);
                tape_here_button_button.setTouchable(Touchable.disabled);
            }

        }});

        ok_up_down_button.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                                   animationLabel.resume();
                animationLabel.restart();
                animationLabel.setVisible(true);
          typingLabel.resume();
          nowapplytouch=true;
          ok_up_down_button.setVisible(false);
          ok_up_down_button.setTouchable(Touchable.disabled);




            }
        });
        isslustrationbutton.addListener(new ClickListener(){
              public void clicked(InputEvent event, float x, float y) {
                  illustrations=true;
                  typingLabel.setVisible(!typingLabel.isVisible());
                  animationLabel.setVisible(!animationLabel.isVisible());
                  typinglabel_for_section.setVisible(!typinglabel_for_section.isVisible());

                  typinglabel_illustration.setVisible(true);
                  typinglabel_illustration.resume();
                  typinglabel_illustration.restart();
                  isslustrationbutton.setVisible(false);;
                  isslustrationbutton.setTouchable(Touchable.disabled);
//                  camera.position.y=1195;
                  camera.position.y += typinglabel_for_section.getY()+typinglabel_for_section.getHeight()/2f;

                  // Applyin my current limits
                          typinglabel_illustration.setText(section100.Sentence_Explain.get(2));
                  camera.update();

                  System.out.println("y of illus and its height:: "+typinglabel_illustration.getY() + " with height " + typinglabel_illustration.getHeight());
                  System.out.println("illus highest point::"+(typinglabel_illustration.getY()+typinglabel_illustration.getHeight()));
                  System.out.println("image where is formed::"+p8.higurumaImages.getWidth() + " by " + p8.higurumaImages.getHeight());
                  System.out.println("camera and viewport location ::"+viewport.getWorldWidth() + " by " + viewport.getWorldHeight() + " with camera " +viewport.getCamera().position);


              }

        });

        //simplfu buttonaction//
simplfybutton.addListener(new ClickListener(){
    public void clicked(InputEvent event, float x, float y) {
        illustrations=true;
APPLE+=100;
        typingLabel.setVisible(!typingLabel.isVisible());
        animationLabel.setVisible(!animationLabel.isVisible());
        typinglabel_for_section.setVisible(!typinglabel_for_section.isVisible());
        typinglabel_illustration.setVisible(!typinglabel_illustration.isVisible());
        camera.position.y=typinglabel_illustration.getY()+typinglabel_illustration.getHeight()/2f;
    }
});

        typinglabel_illustration.setDebug(true);
    }


    @Override
    //REMEMEBER ONE THING NEVER CREATE A VARIABLE INSIDE SHOW CUZ THEN THAT WOULD BE LOCAL VARIABLE
    //MEANING RENDER CANT ACCES TO IT DEFINE IT OUTSIDE THEN U CAN GIVE IT VALUES!!
    public void render(float v) {
        timers+=v;
        ScreenUtils.clear(0,0,1,resolu);
        font.setColor(0,0,0,resolu);
        batch.begin();
     batch.draw(TextureBACKGROUND,0,0   ,

            viewport.getWorldWidth()+10f,viewport.getWorldHeight()+10f
        );

             if(autoCamera){
            camera.position.y=MathUtils.lerp(camera.position.y,targetY,0.05f);
            camera.update();
            if(Math.abs(camera.position.y-targetY)<1f){
                camera.position.y=targetY;
                autoCamera=false;
             /*   game.setScreen(new TestScreen(game));*/
                manualCamera=true;
            }


        }
        if(timers<=1.3){
            if(isTrue_false_2){
                batch.draw(bBoxofdialouge,1,0,Gdx.graphics.getWidth()-2,Gdx.graphics.getHeight()-100);
            }

        }
        if(timers>=1.3){
            alphi+=(2*v)/3; onlyonetimer=0;   alphi=Math.min(alphi,1f);
            batch.setColor(1,1,1,alphi);

            if(!startthelesson){
                batch.draw(pages[numerber].higurumaImages,100,100,pages[numerber].higurumaImages.getWidth()*2,pages[numerber].higurumaImages.getHeight()*2+pages[numerber].extraHeight );
            }
          batch.setColor(Color.WHITE);

            if(isTrue_false_2){
                batch.draw(bBoxofdialouge,1,0,Gdx.graphics.getWidth()-2,Gdx.graphics.getHeight()-100);
            }
        }


        batch.draw(textlineforwheretheyshouldstart,20,320,50,50);

batch.end();

        if(timers>=3){


if(startthelesson) {
    batch.begin();
    if (thefade < 1) {
        thefade += v / 2f;
    }

    Gdx.gl.glClearColor(0.01f, 0.01f, 0.01f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    ;

    batch.setColor(1f, 1f, 1f, thefade);
    batch.draw(TextureBACKGROUND, 0, 0, viewport.getWorldWidth(), viewport.getWorldHeight());
    if (!illustrations) {
        if (true_false_1) {
            alphi2 += (2 * v) / 3;
            onlyonetimer = 0;
            alphi = Math.min(alphi2, 1f);
            batch.setColor(1, 1, 1, alphi2);

            batch.draw(pages[4 + mo].higurumaImages, 100, 100, pages[numerber].higurumaImages.getWidth() * 2, pages[numerber].higurumaImages.getHeight() * 2 + pages[numerber].extraHeight);
        }
        if (isTrue_false_2) {
            batch.draw(bBoxofdialouge, 1, 0, Gdx.graphics.getWidth() - 2, Gdx.graphics.getHeight() - 100);
        }


        batch.end();
    }
}
if(nowapplytouch){


    if(!illustrations){
        if(batch.isDrawing()==true){
            batch.end();
        }else{
            batch.begin();
        }

        batch.draw(TextureBACKGROUND2,0,-viewport.getWorldHeight(),viewport.getWorldWidth(),viewport.getWorldHeight());

    }
 if(illustrations){
    batch.draw(TextureBACKGROUND,0,0,viewport.getWorldWidth(),viewport.getWorldHeight()+2500);
    batch.draw(TextureBACKGROUND,0,-(viewport.getWorldHeight()),viewport.getWorldWidth(),viewport.getWorldHeight()+5000);
     batch.draw(TextureBACKGROUND,0,((-2)*viewport.getWorldHeight()),viewport.getWorldWidth(),viewport.getWorldHeight()+5000);
    if(lastdraw){
            /*batch.draw(p8.higurumaImages, -100,typinglabel_illustration.getY()-p8.higurumaImages.getHeight()-APPLE, pages[numerber].higurumaImages.getWidth() * 2, pages[numerber].higurumaImages.getHeight() * 2 + pages[numerber].extraHeight);*/
        batch.draw(p8.higurumaImages,-100,-viewport.getWorldHeight()-500, pages[numerber].higurumaImages.getWidth() * 2, pages[numerber].higurumaImages.getHeight() * 2 + pages[numerber].extraHeight);
        //batch.draw(bBoxofdialouge,20,lastwordtypinglabel.getY(),Gdx.graphics.getWidth() - 2, Gdx.graphics.getHeight() - 100);

    }

   }
    batch.end();
/*
OLD TOUCH
    if(Gdx.input.isTouched()){
          float currentY=Gdx.input.getY();

           if(lastTouchY!=0){
               float  deltaY=(lastTouchY-currentY)*1.5f;
               camera.position.y-=deltaY;

               velocityY = deltaY;

           lastTouchY=currentY;
       } else {

           lastTouchY = 0;
           camera.position.y -= velocityY;

               velocityY *= damping;
           }
    }*//*  good working inputt
    if (Gdx.input.isTouched()) {
        float currentY = Gdx.input.getY();

        if (lastTouchY == 0) {
            lastTouchY = currentY;    // first frame of touch
        } else {
            float deltaY = (lastTouchY - currentY) * 1.5f;


            if (Math.abs(deltaY) > 2) {
                deltaY *= 1.5f;

                camera.position.y -= deltaY;
                velocityY = deltaY;
            }

            lastTouchY = currentY;
        }
    } else {
        lastTouchY = 0;

        camera.position.y -= velocityY;
        velocityY *= damping;
    }
*/
    if (Gdx.input.isTouched()) {
        float currentY = Gdx.input.getY();
        System.out.println("current Y::"+currentY);
        System.out.println("height and Y of typingscetion ::;"+typinglabel_for_section.getHeight()+","+typinglabel_for_section.getY());

        if (lastTouchY == 0) {
            lastTouchY = currentY;
        } else {
            float deltaY = (lastTouchY - currentY);

            // Smaller dead zone
            if (Math.abs(deltaY) > 0.5f) {

                // Increase scroll sensitivity
                deltaY *= 2.2f;

                camera.position.y -= deltaY;

                // Smooth velocity instead of replacing it
                velocityY = velocityY * 0.7f + deltaY * 0.3f;
            }

            lastTouchY = currentY;
        }
    } else {
        lastTouchY = 0;

        camera.position.y -= velocityY;
        velocityY *= 0.92f;   // or use thy damping variable
    }
    if(typinglabel_illustration.isVisible()){
        camera.position.y = Math.max((-viewport.getWorldHeight()*10)/11f,
            Math.min(camera.position.y,viewport.getWorldHeight()/2f));
        camera.update();

    }else{
        camera.position.y = Math.max(-viewport.getWorldHeight()/25f,
            Math.min(camera.position.y,viewport.getWorldHeight()/2f)

        );


        camera.update();
    }

}
            resolu+=v/2f; resolu=Math.min(resolu,1f);
            stage.act(v);
          //  System.out.println("Button visible: " + tape_here_button_button.isVisible());
            stage.draw();


        }
    }

    @Override
    public void resize(int i, int i1) {
 viewport.update(i,i1,true);
 stage.getViewport().update(i,i1,true);
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
        bBoxofdialouge.dispose(); TextureBACKGROUND.getTexture().dispose(); Backgroud.dispose();
        TextureBACKGROUND2.getTexture().dispose();
        stage.dispose();
    }
}
