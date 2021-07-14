package com.gas.switcher.management;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Prefs {
    private Preferences pref;
    private boolean levelOneComplete;
    private boolean levelTwoComplete;
    private boolean levelThreeComplete;
    private boolean levelFourComplete;
    private boolean levelFiveComplete;
    private boolean levelSixComplete;
    private boolean levelSevenComplete;
    private boolean levelEightComplete;
    private boolean levelNineComplete;

    public Prefs(){
        pref = Gdx.app.getPreferences("My Preferences");
        levelOneComplete = pref.getBoolean("one",false);
        levelTwoComplete = pref.getBoolean("two",false);
        levelThreeComplete = pref.getBoolean("three",false);
        levelFourComplete = pref.getBoolean("four",false);
        levelFiveComplete = pref.getBoolean("five",false);
        levelSixComplete = pref.getBoolean("six",false);
        levelSevenComplete = pref.getBoolean("seven",false);
        levelEightComplete = pref.getBoolean("eight",false);
        levelNineComplete = pref.getBoolean("nine",false);
    }

    //should be called once when we need to increase my level
    public void setLevel(int level, boolean status){
        switch (level){
            case 1:
                levelOneComplete = status;
                pref.putBoolean("one", levelOneComplete);
                break;
            case 2:
                levelTwoComplete = status;
                pref.putBoolean("two", levelTwoComplete);
                break;
            case 3:
                levelThreeComplete = status;
                pref.putBoolean("three", levelThreeComplete);
                break;
            case 4:
                levelFourComplete = status;
                pref.putBoolean("four", levelFourComplete);
                break;
            case 5:
                levelFiveComplete = status;
                pref.putBoolean("five", levelFiveComplete);
                break;
            case 6:
                levelSixComplete = status;
                pref.putBoolean("six", levelSixComplete);
                break;
            case 7:
                levelSevenComplete = status;
                pref.putBoolean("seven", levelSevenComplete);
                break;
            case 8:
                levelEightComplete = status;
                pref.putBoolean("eight", levelEightComplete);
                break;
            case 9:
                levelNineComplete = status;
                pref.putBoolean("nine", levelNineComplete);
                break;

        }
        pref.flush();
    }

    public boolean getLevelStatus(int level){
        switch (level){
            case 1: return levelOneComplete;
            case 2: return levelTwoComplete;
            case 3: return levelThreeComplete;
            case 4: return levelFourComplete;
            case 5: return levelFiveComplete;
            case 6: return levelSixComplete;
            case 7: return levelSevenComplete;
            case 8: return levelEightComplete;
            case 9: return levelNineComplete;

            default: return false;
        }
    }

    public void clear(){
        pref.clear();
        pref.flush();
        levelOneComplete = pref.getBoolean("one",false);
        levelTwoComplete = pref.getBoolean("two",false);
        levelThreeComplete = pref.getBoolean("three",false);
        levelFourComplete = pref.getBoolean("four",false);
        levelFiveComplete = pref.getBoolean("five",false);
        levelSixComplete = pref.getBoolean("six",false);
        levelSevenComplete = pref.getBoolean("seven",false);
        levelEightComplete = pref.getBoolean("eight",false);
        levelNineComplete = pref.getBoolean("nine",false);
    }
}
