package com.gas.switcher.scenes.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.gas.switcher.Switcher;
import com.gas.switcher.management.SceneManager;
import com.gas.switcher.scenes.Board;
import com.gas.switcher.utils.AssetPaths;
import com.gas.switcher.utils.Levels;

public class RetryButton extends Actor {

    private final Switcher switcher;
    private Sprite sprite;
    private final String name;
    private final Sprite shadowOut;
    private final Sprite shadowIn;
    private final Sprite shadowGate;
    private final Sprite icon;
    private boolean animate;
    private float counter=1;
    private boolean countUp;
    private boolean loaded;
    private boolean sceneSwitch;
    private float loadScaler;
    private int wait;

    public RetryButton(final Switcher switcher, Texture texture, final String name, int renderOrder){
        this.switcher = switcher;
        this.icon = new Sprite(texture);
        this.shadowOut = new Sprite((Texture) switcher.assetManager.get(AssetPaths.SHADOW_OUT));
        this.shadowOut.setOriginCenter();
        this.shadowIn = new Sprite((Texture) switcher.assetManager.get(AssetPaths.SHADOW_IN));
        this.shadowIn.setOriginCenter();
        this.shadowGate = new Sprite((Texture) switcher.assetManager.get(AssetPaths.BUTTON_SHADOWGATE));
        this.shadowGate.setOriginCenter();
        this.name = name;
        this.wait = 10*renderOrder;
        sprite = new Sprite((Texture) switcher.assetManager.get(AssetPaths.BUTTON));
        spritePos(sprite.getX(), sprite.getY());
        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(loaded&&!animate&&!sceneSwitch) {
                    Gdx.app.log("TOUCH: Touch down actor with name", name);
                    counter = 1;
                    countUp = true;
                    animate = true;
                    switcher.sceneManager.setScene(SceneManager.GAMESTATE.PLAYING);
                }
                return true;
            }
        });
    }

    public void spritePos(float x, float y){
        sprite.setPosition(x, y);
        shadowOut.setPosition(x-25, y-25);
        shadowIn.setPosition(x-25,y-25);
        shadowGate.setPosition(x-75, y-75);
        icon.setPosition(x, y);
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }

    @Override
    public void act(float delta) {
        if(!loaded&&wait<=0){
            loadScaler+=0.04f;
        }
        if(wait>0){
            wait--;
        }
        if(loadScaler>=1f){
            loaded=true;
            loadScaler=0;
        }
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (animate) {
                shadowOut.setScale(1 - counter / 80);
                icon.setScale(1 - counter / 200);
                if (countUp) {
                    counter++;
                } else {
                    counter--;
                }
            }
            if (counter >= 10 && !sceneSwitch) {
                Gdx.input.vibrate(40);
                if(switcher.isSoundEffectsOn()) switcher.getClick().play();
                countUp = false;
            }
            if (sceneSwitch) {
                if (counter <= 20) {
                    shadowOut.setScale(1 - counter / 40);
                    icon.setScale(1 - counter / 20);
                    counter++;
                } else {
                    sceneSwitch = false;
                    counter = -1;
                }
            }
            if (counter == 0) {
                shadowOut.setScale(1);
                sprite.setScale(1);
                animate = false;
            }
            if (!loaded) {
                shadowOut.setScale(0.75f + loadScaler / 4);
                icon.setScale(loadScaler);
            }
            if (counter == -1 && !sceneSwitch) {
                counter = 1;
            }
            shadowOut.draw(batch);
            sprite.draw(batch);
            icon.draw(batch);
        }

    public String getName(){
        return this.name;
    }

    public void startSceneSwitchAnimation(){
        counter = 0;
        sceneSwitch=true;
    }

    public boolean isLoaded(){
        return loaded;
    }
}