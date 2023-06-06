package com.example.myapplication2;

public class Item2 {
    String TeamName,TeamImage;







    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getTeamImage() {
        return TeamImage;
    }

    public void setTeamImage(String teamImage) {
        TeamImage = teamImage;
    }

    public Item2(String TeamName, String Image) {
        this.TeamName = TeamName;
        this.TeamImage = Image;


    }
}
