package com.example.demo.domain;

import org.springframework.web.bind.annotation.RequestParam;

public class Application {
    private String userName;
    private String appName;
    private int reward;
    private int year;
    private String season;
    private String sugSys;
    private String description;
    private int stuNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    @Override
    public String toString() {
        return "Application{" +
                "userName='" + userName + '\'' +
                ", appName='" + appName + '\'' +
                ", reward=" + reward +
                ", year=" + year +
                ", season='" + season + '\'' +
                ", sugSys='" + sugSys + '\'' +
                ", description='" + description + '\'' +
                ", stuNum=" + stuNum +
                '}';
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSugSys() {
        return sugSys;
    }

    public void setSugSys(String sugSys) {
        this.sugSys = sugSys;
    }
}
