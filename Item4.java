package com.example.myapplication2;

public class Item4 {
    String homeTeamName,awayTeamName,versus,homeTeamImage,awayTeamImage,tarih,saat,homeTeamScore,awayTeamScore;

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getVersus() {
        return versus;
    }

    public void setVersus(String versus) {
        this.versus = versus;
    }

    public String getHomeTeamImage() {
        return homeTeamImage;
    }

    public void setHomeTeamImage(String homeTeamImage) {
        this.homeTeamImage = homeTeamImage;
    }

    public String getAwayTeamImage() {
        return awayTeamImage;
    }

    public void setAwayTeamImage(String awayTeamImage) {
        this.awayTeamImage = awayTeamImage;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(String homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public String getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(String awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public Item4(String homeTeamName, String awayTeamName, String versus, String homeTeamImage, String awayTeamImage, String tarih, String saat,String homeTeamScore, String awayTeamScore) {
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.versus = versus;
        this.homeTeamImage = homeTeamImage;
        this.awayTeamImage = awayTeamImage;
        this.tarih = tarih;
        this.saat = saat;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }
}
