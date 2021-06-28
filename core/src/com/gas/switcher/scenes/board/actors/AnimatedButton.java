package com.gas.switcher.scenes.board.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.gas.switcher.Switcher;
import com.gas.switcher.utils.AssetPaths;

public class AnimatedButton extends Actor {

    private final Switcher switcher;
    private Sprite sprite;
    private String name;
    private final AnimatedButton itsaMe = this;
    private final Texture highlightTexture;

    public AnimatedButton(Switcher switcher, Texture texture, final String name){
        this.switcher = switcher;
        this.highlightTexture = switcher.assetManager.get(AssetPaths.BOARD_BACKGROUND);
        this.name = name;
        spritePos(sprite.getX(), sprite.getY());
        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("CARDTOUCH: Touch down asset with name ", name);
                return true;
            }
        });
    }

    public void spritePos(float x, float y){
        sprite.setPosition(x, y);
        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

    public String getName(){
        return this.name;
    }

    public void setSprite(Texture texture){
        float x = sprite.getX();
        float y = sprite.getY();
        sprite = new Sprite(texture);
        spritePos(x, y);
    }
}