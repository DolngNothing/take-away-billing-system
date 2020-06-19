package main;

import model.Meal;

import java.util.*;

public class main {
    public static void main(String[] args) {
        HashMap<String,Meal> mealList=new HashMap<>();
        mealList.put("ITEM0001",new Meal("ITEM0001","Braised chicken",true,18));
        mealList.put("ITEM0013",new Meal("ITEM0013","Chinese hamburger",false,6));
        mealList.put("ITEM0022",new Meal("ITEM0022","Cold noodles",true,8));

        App app=new App();
        app.bestCharge(app.creatMenu(mealList));

    }
}
