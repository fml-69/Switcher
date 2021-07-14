package com.gas.switcher.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.gas.switcher.Switcher;
import com.gas.switcher.scenes.actors.UniversalButton;
import com.gas.switcher.utils.AssetPaths;

public class Options extends AbstractScene {

    private OrthographicCamera camera;
    private Image background;
    private static UniversalButton soundSwitch;
    private static UniversalButton resetStats;
    private static UniversalButton back;

    public Options(final Switcher switcher) {
        super(switcher);
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Switcher.SCALE_WIDTH, Switcher.SCALE_HEIGHT);
        this.stage = new Stage(new FitViewport(Switcher.SCALE_WIDTH, Switcher.SCALE_HEIGHT, camera));
        switcher.batch.setProjectionMatrix(camera.combined);
        background = new Image((Texture) switcher.assetManager.get(AssetPaths.BACKGROUND));
        background.setScale(1.2f);
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
        stage.clear();
        stage.addActor(background);
        soundSwitch = new UniversalButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CHECK), "soundSwitch", 0);
        soundSwitch.spritePos(415, 835);
        stage.addActor(soundSwitch);
        resetStats = new UniversalButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_RETRY), "resetStats", 1);
        resetStats.spritePos(415, 500);
        stage.addActor(resetStats);

        back = new UniversalButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_BACK), "backToMenu", 2);
        back.spritePos(80, 80);
        stage.addActor(back);
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

    public static void leaveScene(){
        soundSwitch.startSceneSwitchAnimation();
        resetStats.startSceneSwitchAnimation();
        back.startSceneSwitchAnimation();
    }

}
