package com.example.myapplication2;

public class Item3 {

    String teamName,imageUrl,position, point;;


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Item3(String position, String point, String teamName, String imageUrl) {
        this.position = position;
        this.point = point;
        this.teamName = teamName;
        this.imageUrl = imageUrl;
    }


}
