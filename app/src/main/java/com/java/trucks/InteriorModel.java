package com.java.trucks;

public class InteriorModel {

    String interiorName;
    int id;

    InteriorModel(String interiorName, int id){
        this.interiorName = interiorName;
        this.id = id;
    }

    public String getInteriorName(){
        return interiorName;
    }
    public int getId(){
        return id;
    }
}
