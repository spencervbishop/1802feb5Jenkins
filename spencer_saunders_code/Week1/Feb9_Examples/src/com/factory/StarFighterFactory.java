package com.factory;

import java.util.HashMap;
import java.util.Map;

public class StarFighterFactory {

    private static Map<String, Class> ships = new HashMap<>();   //we're using static so we don't ne

    public static void registerShip(String id, Class clazz){
        ships.put(id, clazz);
    }

    public static Starfighter createStarFighter(String fighterId) throws Exception{
        Class clazz = ships.get(fighterId);

        if(clazz==null){
            throw new Exception("This factory doesn't make those types of star fighters " + fighterId);
        }

        return (Starfighter)clazz.newInstance();
    }
}
