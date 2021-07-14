package com.gas.switcher.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.gas.switcher.Switcher;
import com.gas.switcher.scenes.actors.UniversalButton;
import com.gas.switcher.utils.AssetPaths;
import com.gas.switcher.utils.Levels;


public class WinningScreen extends AbstractScene {

    private OrthographicCamera camera;
    private Image background;
    private static UniversalButton back;
    private static int moveCount;

    public WinningScreen(final Switcher switcher) {
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
        moveCount = Board.getMoveCount();
        stage.clear();
        stage.addActor(background);
        switcher.prefs.setLevel(switcher.getLevel(), true);
        Label label = new Label("Congratulations! You cleared all fields using "+Board.getMoveCount()+" moves.", new Skin(Gdx.files.internal("skins/clean-crispy-ui.json")));
        label.setWidth(300);
        label.setHeight(100);
        label.setFontScale(2);
        label.setPosition(400, 935);
        label.setAlignment(Align.center);
        stage.addActor(label);
        back = new UniversalButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_BACK), "backToLevelsWinning", 1);
        back.spritePos(415, 500);
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
        back.startSceneSwitchAnimation();
    }

}
