package com.gas.switcher.management;

import com.gas.switcher.Switcher;
import com.gas.switcher.scenes.AbstractScene;
import com.gas.switcher.scenes.Board;
import com.gas.switcher.scenes.LevelOverview;
import com.gas.switcher.scenes.Menu;
import com.gas.switcher.scenes.Options;
import com.gas.switcher.scenes.WinningScreen;

import java.util.HashMap;

public class SceneManager {

    private final Switcher switcher;
    private HashMap<GAMESTATE, AbstractScene> sceneHashMap;
    public enum GAMESTATE{MENU, OPTIONS, LEVELOVERVIEW, PLAYING, WINNING}

    private AbstractScene activeScene;

    public SceneManager(final Switcher switcher){
        this.switcher = switcher;
        sceneMapper();
        setScene(GAMESTATE.MENU);
    }

    private void sceneMapper(){
        this.sceneHashMap = new HashMap<>();
        this.sceneHashMap.put(GAMESTATE.MENU, new Menu(switcher));
        this.sceneHashMap.put(GAMESTATE.OPTIONS, new Options(switcher));
        this.sceneHashMap.put(GAMESTATE.LEVELOVERVIEW, new LevelOverview(switcher));
        this.sceneHashMap.put(GAMESTATE.PLAYING, new Board(switcher));
        this.sceneHashMap.put(GAMESTATE.WINNING, new WinningScreen(switcher));
    }


    public void setScene(GAMESTATE scene){
        AbstractScene newScene = sceneHashMap.get(scene);
        switcher.setScreen(newScene);
        activeScene = newScene;
    }

    public void dispose(){
        for(AbstractScene abstractScene: sceneHashMap.values()){
            if(abstractScene!=null){
                abstractScene.dispose();
            }
        }
    }

    public AbstractScene getActiveScene(){
        return activeScene;
    }

}
