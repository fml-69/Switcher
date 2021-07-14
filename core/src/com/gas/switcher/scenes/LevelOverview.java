package com.gas.switcher.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.gas.switcher.Switcher;
import com.gas.switcher.scenes.actors.UniversalButton;
import com.gas.switcher.scenes.actors.LevelButton;
import com.gas.switcher.utils.AssetPaths;


public class LevelOverview extends AbstractScene {

    private OrthographicCamera camera;
    private Image background;
    private static LevelButton levelOne;
    private static LevelButton levelTwo;
    private static LevelButton levelThree;
    private static LevelButton levelFour;
    private static LevelButton levelFive;
    private static LevelButton levelSix;
    private static LevelButton levelSeven;
    private static LevelButton levelEight;
    private static LevelButton levelNine;
    private static UniversalButton back;

    public LevelOverview(final Switcher switcher) {
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
        if(switcher.prefs.getLevelStatus(1)) {
            levelOne = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CHECK), 1, 0);
        } else {
            levelOne = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), 1, 0);
        }
        levelOne.spritePos(80, 1170);
        stage.addActor(levelOne);

        if(switcher.prefs.getLevelStatus(2)) {
            levelTwo = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CHECK), 2, 1);
        } else {
            levelTwo = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), 2, 1);
        }
        levelTwo.spritePos(415, 1170);
        stage.addActor(levelTwo);

        if(switcher.prefs.getLevelStatus(3)) {
            levelThree = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CHECK), 3, 2);
        } else {
            levelThree = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), 3, 2);
        }
        levelThree.spritePos(750, 1170);
        stage.addActor(levelThree);

        if(switcher.prefs.getLevelStatus(4)) {
            levelFour = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CHECK), 4, 1);
        } else {
            levelFour = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), 4, 1);
        }
        levelFour.spritePos(80, 835);
        stage.addActor(levelFour);

        if(switcher.prefs.getLevelStatus(5)) {
            levelFive = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CHECK), 5, 2);
        } else {
            levelFive = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), 5, 2);
        }
        levelFive.spritePos(415, 835);
        stage.addActor(levelFive);

        if(switcher.prefs.getLevelStatus(6)) {
            levelSix = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CHECK), 6, 3);
        } else {
            levelSix = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), 6, 3);
        }
        levelSix.spritePos(750, 835);
        stage.addActor(levelSix);

        if(switcher.prefs.getLevelStatus(7)) {
            levelSeven = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CHECK), 7, 2);
        } else {
            levelSeven = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), 7, 2);
        }
        levelSeven.spritePos(80, 500);
        stage.addActor(levelSeven);

        if(switcher.prefs.getLevelStatus(8)) {
            levelEight = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CHECK), 8, 3);
        } else {
            levelEight = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), 8, 3);
        }
        levelEight.spritePos(415, 500);
        stage.addActor(levelEight);

        if(switcher.prefs.getLevelStatus(9)) {
            levelNine = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CHECK), 9, 4);
        } else {
            levelNine = new LevelButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), 9, 4);
        }
        levelNine.spritePos(750, 500);
        stage.addActor(levelNine);

        back = new UniversalButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_BACK), "backToMenuLevels", 3);
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
        levelOne.startSceneSwitchAnimation();
        levelTwo.startSceneSwitchAnimation();
        levelThree.startSceneSwitchAnimation();
        levelFour.startSceneSwitchAnimation();
        levelFive.startSceneSwitchAnimation();
        levelSix.startSceneSwitchAnimation();
        levelSeven.startSceneSwitchAnimation();
        levelEight.startSceneSwitchAnimation();
        levelNine.startSceneSwitchAnimation();
        back.startSceneSwitchAnimation();
    }

}
