package com.gas.switcher.management;

import com.gas.switcher.Switcher;
import com.gas.switcher.scenes.AbstractScene;
import com.gas.switcher.scenes.board.Board;

import java.util.HashMap;

public class SceneManager {

    private final Switcher switcher;
    private HashMap<GAMESTATE, AbstractScene> sceneHashMap;
    public enum GAMESTATE{PLAYING}

    private AbstractScene activeScene;

    public SceneManager(final Switcher switcher){
        this.switcher = switcher;
        sceneMapper();
        setScene(GAMESTATE.PLAYING);
    }

    private void sceneMapper(){
        this.sceneHashMap = new HashMap<>();
        this.sceneHashMap.put(GAMESTATE.PLAYING, new Board(switcher));
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
