package io.github.quillraven.slimesur;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.Game;


/** {@link ApplicationListener} implementation shared by all platforms. */
public class GdxDEMOANDROIDGame extends Game {

    private SpriteBatch batch;
    private TextureRegion textureRegion;

    private TextureRegion textureRegionB;
   ;Texture backgroundB;
   Texture higurumaimage;
    private ExtendViewport extendViewport;
    private FitViewport fitViewport;
    private Texture image;
    Texture background;
    OrthographicCamera camera ;
    float top,bottom,right,left;
    int a,b;
    float lastTouchY;
    ;
    float velocityY;
    float damping ;

    final Color[] currentColor  = {Color.RED};
    private Stage stage;
    private Skin skin;
    Texture popuptexture;

    @Override
    public void create() {

        batch = new SpriteBatch();
a=900;b=2000;
        extendViewport= new ExtendViewport(a, b);

        stage=new Stage(extendViewport,batch);
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(
            Gdx.files.internal("cloud-form-ui.json")
        );
        float cameraSpeed = 500;
      background=new Texture(Gdx.files.internal("mapy.png"));
        backgroundB=new Texture(Gdx.files.internal("mapytwo.png"));
        higurumaimage=new Texture(Gdx.files.internal("higu.png"));
int xc;

        popuptexture=new Texture("popup.png");
        Image popupBG=new Image(new  TextureRegionDrawable(new TextureRegion(popuptexture)));
        Group popupGroup=new Group();
        popupGroup.setPosition(460f, 300f);
//y is height  x is length  the more y will be the more high it will go  and the more x will be the more right side it will go

        popupGroup.setSize(300f, 200f);
        popupBG.setSize(300f, 200f);
        popupGroup.addActor(popupBG);
        Label text=new Label("LEVEL 1:basic of the game",skin);
        text.setPosition(30f, 140f);
popupGroup.addActor(text);
popupGroup.setVisible(false);
        stage.addActor(popupGroup);

        Texture buttonTexture =
            new Texture("buttondownlevel1.png");

        Texture pressedTexture =
            new Texture("buttonuplevel1.png");
        TextureRegionDrawable upDrawable =
            new TextureRegionDrawable(
                new TextureRegion(buttonTexture));

        TextureRegionDrawable downDrawable =
            new TextureRegionDrawable(
                new TextureRegion(pressedTexture));
        ImageButton.ImageButtonStyle style =
            new ImageButton.ImageButtonStyle();

        style.up = upDrawable;
        style.down = downDrawable;

        ImageButton buttonq =
            new ImageButton(style);

        popupGroup.setTouchable(Touchable.enabled);
        popupBG.setTouchable(Touchable.enabled);
       textureRegion = new TextureRegion(background);
        textureRegionB = new TextureRegion(backgroundB);

      extendViewport.getCamera().position.set(a/2,b/2, 0);
        extendViewport.getCamera().update();
        camera=
            (OrthographicCamera) extendViewport.getCamera();
      image = new Texture("libgdx.png");
         left = camera.position.x - extendViewport.getWorldWidth()/2;

         right = camera.position.x + extendViewport.getWorldWidth()/2;

         bottom = camera.position.y - extendViewport.getWorldHeight()/2;

         top = camera.position.y + extendViewport.getWorldHeight()/2;
 lastTouchY=0;
  damping = 0.95f;

        xc=1;
        float actor=xc;
float zeero=0f;

        buttonq.setSize(450f, 250f);

        buttonq.setPosition(330f, 140f);

        stage.addActor(buttonq);
        //root.left();
        //root.add(button).size(20f,30f);
        buttonq.addListener(new ChangeListener() {
            @Override

            public void changed(ChangeEvent changeEvent, Actor actor) {
                               popupGroup.setVisible(!popupGroup.isVisible());
                     popupGroup.toFront();
                        if((currentColor[0]==Color.RED)){

                                  currentColor[0]=Color.BLUE;
                        }else{
                            ; currentColor[0]=Color.RED;
;
                        }

            }

        });
popupBG.addListener(new ClickListener(){
    @Override
    public  void clicked(InputEvent event, float x,float y){
        setScreen(new transition(GdxDEMOANDROIDGame.this));
        dispose();
    }

});



    }



    @Override
    public void render() {
        // if another screen is active
        if(getScreen() != null){

            super.render();

            return;
        }

        ScreenUtils.clear(currentColor[0]);
extendViewport.apply();
if(Gdx.input.isTouched()){

    float currentY=Gdx.input.getY();
    if(lastTouchY!=0){
        float  deltaY=(lastTouchY-currentY)*1.5f;
        camera.position.y-=deltaY;

        velocityY = deltaY;
    }
    lastTouchY=currentY;
} else {

    lastTouchY = 0;
    camera.position.y -= velocityY;

    velocityY *= damping;
}

        float maxCameraY =
            (b * 2) - extendViewport.getWorldHeight()/2f;

        float minCameraY =
            extendViewport.getWorldHeight()/2f;

        camera.position.y =
               Math.min(camera.position.y, maxCameraY);

        camera.position.y =
            Math.max(camera.position.y, minCameraY);

        camera.update();
        batch.setProjectionMatrix(extendViewport.getCamera().combined);

        batch.begin();

batch.draw(textureRegion,0,0);
batch.draw(textureRegionB,0,textureRegion.getRegionWidth());
//textureRegion.getRegionWidth() is our height

        batch.end();
        stage.act();
        stage.draw();


    }
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        extendViewport.update(width, height);

    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        background.dispose();

        textureRegion.getTexture().dispose();  textureRegionB.getTexture().dispose();
stage.dispose();
        stage.clear();
    }
}
