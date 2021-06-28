package com.gas.switcher.scenes.board;

import com.gas.switcher.scenes.AbstractScene;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.gas.switcher.Switcher;

public class Board extends AbstractScene {

    private OrthographicCamera camera;

    public Board(final Switcher switcher) {
        super(switcher);
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Switcher.SCALE_WIDTH, Switcher.SCALE_HEIGHT);
        this.stage = new Stage(new StretchViewport(Switcher.SCALE_WIDTH, Switcher.SCALE_HEIGHT, camera));
        switcher.batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
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
}
