package com.java.trucks;

public class StatusModel {

    String statusName;
    int id_2;
    int image2;
    
    public StatusModel(String statusName, int id_2, int image2){
        this.statusName = statusName;
        this.id_2 = id_2;
        this.image2=image2;
    }

    public String getStatusName() {
        return statusName;
    }

    public int getImage2() {
        return image2;
    }

    public int getId2() {
        return id_2;
    }

}
