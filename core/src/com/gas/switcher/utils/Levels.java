package com.gas.switcher.utils;

import java.util.ArrayList;

public class Levels {
    private Levels(){}

    private static ArrayList<boolean[][]> levels = new ArrayList<>();

    public static void initLevels(){
        levels.add(new boolean[][]{{false, true, false},{true,true,true},{false,true,false}});
        levels.add(new boolean[][]{{true, true, true},{true,true,true},{true,true,true}});
        levels.add(new boolean[][]{{false, true, false},{true,true,true},{false,true,false}});
        levels.add(new boolean[][]{{true, true, true},{true,true,true},{true,true,true}});
        levels.add(new boolean[][]{{false, true, false},{true,true,true},{false,true,false}});
        levels.add(new boolean[][]{{true, true, true},{true,true,true},{true,true,true}});
        levels.add(new boolean[][]{{false, true, false},{true,true,true},{false,true,false}});
        levels.add(new boolean[][]{{true, true, true},{true,true,true},{true,true,true}});
        levels.add(new boolean[][]{{false, true, false},{true,true,true},{false,true,false}});
    }

    public static boolean[][] getLevel(int level){
        if(level<=levels.size()) {
            return levels.get(level - 1);
        } else {
            return levels.get(levels.size()-1);
        }
    }

}
