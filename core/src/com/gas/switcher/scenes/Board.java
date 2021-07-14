package com.gas.switcher.scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.gas.switcher.Switcher;
import com.gas.switcher.management.SceneManager;
import com.gas.switcher.scenes.actors.RetryButton;
import com.gas.switcher.scenes.actors.UniversalButton;
import com.gas.switcher.scenes.actors.ModeButton;
import com.gas.switcher.scenes.actors.PlayButton;
import com.gas.switcher.utils.AssetPaths;
import com.gas.switcher.utils.Levels;

import java.util.ArrayList;

public class Board extends AbstractScene {

    private OrthographicCamera camera;
    private Image background;
    private static boolean[][] initialState;
    private static boolean nineMode = true;
    private static int moveCount;
    private int frameCounter;
    private static UniversalButton back;
    private static PlayButton oneOne;
    private static PlayButton oneTwo;
    private static PlayButton oneThree;
    private static PlayButton twoOne;
    private static PlayButton twoTwo;
    private static PlayButton twoThree;
    private static PlayButton threeOne;
    private static PlayButton threeTwo;
    private static PlayButton threeThree;
    private static ModeButton modeFive;
    private static ModeButton modeNine;
    private static RetryButton retryButton;
    private static ArrayList<PlayButton> playButtonList = new ArrayList<>();

    public Board(final Switcher switcher) {
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
        if(isAllFalse()&&moveCount>0){
            if(frameCounter >=40) {
                switcher.sceneManager.setScene(SceneManager.GAMESTATE.WINNING);
                frameCounter = 0;
                moveCount=0;
            }
            frameCounter++;
        }
        stage.act(delta);
    }

    private boolean isAllFalse(){
        for(PlayButton button: playButtonList){
            if(!button.isActivated()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        Gdx.app.log("LEVEL", String.valueOf(switcher.getLevel()));
        initialState = null;
        initialState = Levels.getLevel(switcher.getLevel()).clone();
        stage.clear();
        playButtonList.clear();
        nineMode = false;
        moveCount = 0;
        stage.addActor(background);
        back = new UniversalButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_BACK), "backToLevels", 0);
        back.spritePos(80, 1590);
        stage.addActor(back);

        oneOne = new PlayButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), "11", 1);
        oneOne.spritePos(80, 1170);
        playButtonList.add(oneOne);
        stage.addActor(oneOne);
        oneTwo = new PlayButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), "12", 2);
        oneTwo.spritePos(415, 1170);
        playButtonList.add(oneTwo);
        stage.addActor(oneTwo);
        oneThree = new PlayButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), "13", 3);
        oneThree.spritePos(750, 1170);
        playButtonList.add(oneThree);
        stage.addActor(oneThree);

        twoOne = new PlayButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), "21", 2);
        twoOne.spritePos(80, 835);
        playButtonList.add(twoOne);
        stage.addActor(twoOne);
        twoTwo = new PlayButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), "22", 3);
        twoTwo.spritePos(415, 835);
        playButtonList.add(twoTwo);
        stage.addActor(twoTwo);
        twoThree = new PlayButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), "23", 4);
        twoThree.spritePos(750, 835);
        playButtonList.add(twoThree);
        stage.addActor(twoThree);

        threeOne = new PlayButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), "31", 3);
        threeOne.spritePos(80, 500);
        playButtonList.add(threeOne);
        stage.addActor(threeOne);
        threeTwo = new PlayButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), "32", 4);
        threeTwo.spritePos(415, 500);
        playButtonList.add(threeTwo);
        stage.addActor(threeTwo);
        threeThree = new PlayButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_CIRCLE), "33", 5);
        threeThree.spritePos(750, 500);
        playButtonList.add(threeThree);
        stage.addActor(threeThree);

        modeFive = new ModeButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_FIVE), "modeFive", 4);
        modeFive.spritePos(80, 80);
        stage.addActor(modeFive);

        modeNine = new ModeButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_NINE), "modeNine", 5);
        modeNine.spritePos(415, 80);
        stage.addActor(modeNine);

        retryButton = new RetryButton(switcher, (Texture) switcher.assetManager.get(AssetPaths.BUTTON_RETRY), "retry", 6);
        retryButton.spritePos(750, 80);
        stage.addActor(retryButton);

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
        oneOne.startSceneSwitchAnimation();
        oneTwo.startSceneSwitchAnimation();
        oneThree.startSceneSwitchAnimation();
        twoOne.startSceneSwitchAnimation();
        twoTwo.startSceneSwitchAnimation();
        twoThree.startSceneSwitchAnimation();
        threeOne.startSceneSwitchAnimation();
        threeTwo.startSceneSwitchAnimation();
        threeThree.startSceneSwitchAnimation();
        modeFive.startSceneSwitchAnimation();
        modeNine.startSceneSwitchAnimation();
        retryButton.startSceneSwitchAnimation();
    }

    public static void move(String name){
        if (nineMode){
            switch (name){
                case "22":
                    threeOne.externalClick();
                    threeTwo.externalClick();
                    threeThree.externalClick();
                case "12":
                    oneThree.externalClick();
                    twoThree.externalClick();
                case "11":
                    oneOne.externalClick();
                    oneTwo.externalClick();
                    twoOne.externalClick();
                    twoTwo.externalClick();
                    moveCount++;
                    break;
                case "23":
                    threeTwo.externalClick();
                    threeThree.externalClick();
                case "13":
                    oneTwo.externalClick();
                    oneThree.externalClick();
                    twoTwo.externalClick();
                    twoThree.externalClick();
                    moveCount++;
                    break;
                case "21":
                    oneOne.externalClick();
                    oneTwo.externalClick();
                    twoOne.externalClick();
                    twoTwo.externalClick();
                    threeOne.externalClick();
                    threeTwo.externalClick();
                    moveCount++;
                    break;
                case "32":
                    twoThree.externalClick();
                    threeThree.externalClick();
                case "31":
                    twoOne.externalClick();
                    twoTwo.externalClick();
                    threeOne.externalClick();
                    threeTwo.externalClick();
                    moveCount++;
                    break;
                case "33":
                    twoTwo.externalClick();
                    twoThree.externalClick();
                    threeTwo.externalClick();
                    threeThree.externalClick();
                    moveCount++;
                    break;
            }
        } else {
            switch (name){
                case "11":
                    oneOne.externalClick();
                    oneTwo.externalClick();
                    twoOne.externalClick();
                    moveCount++;
                    break;
                case "12":
                    oneOne.externalClick();
                    oneTwo.externalClick();
                    oneThree.externalClick();
                    twoTwo.externalClick();
                    moveCount++;
                    break;
                case "13":
                    oneTwo.externalClick();
                    oneThree.externalClick();
                    twoThree.externalClick();
                    moveCount++;
                    break;
                case "21":
                    oneOne.externalClick();
                    twoOne.externalClick();
                    twoTwo.externalClick();
                    threeOne.externalClick();
                    moveCount++;
                    break;
                case "22":
                    oneTwo.externalClick();
                    twoOne.externalClick();
                    twoTwo.externalClick();
                    twoThree.externalClick();
                    threeTwo.externalClick();
                    moveCount++;
                    break;
                case "31":
                    twoOne.externalClick();
                    threeOne.externalClick();
                    threeTwo.externalClick();
                    moveCount++;
                    break;
                case "32":
                    twoTwo.externalClick();
                    threeOne.externalClick();
                    threeTwo.externalClick();
                    threeThree.externalClick();
                    moveCount++;
                    break;
                case "33":
                    twoThree.externalClick();
                    threeTwo.externalClick();
                    threeThree.externalClick();
                    moveCount++;
                    break;
            }
        }
    }

    public static boolean[][] getState() {
        return initialState;
    }

    public static ArrayList<PlayButton> getPlayButtonList() {
        return playButtonList;
    }

    public static boolean isNineMode(){
        return nineMode;
    }

    public static void switchNineMode(){
        nineMode = !nineMode;
    }

    public static int getMoveCount(){
        return moveCount;
    }

}
