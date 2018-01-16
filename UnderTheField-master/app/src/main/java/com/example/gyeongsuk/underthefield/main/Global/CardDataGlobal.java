package com.example.gyeongsuk.underthefield.main.Global;

/**
 * Created by Gyeongsuk on 2016-12-03.
 */

public class CardDataGlobal {

    private String globalScUrl;
    private String globalUserName;

    public String getGlobalScUrl() {
        return globalScUrl;
    }

    public void setGlobalScUrl(String globalScUrl) {
        this.globalScUrl = globalScUrl;
    }

    public String getGlobalUserName() {
        return globalUserName;
    }

    public void setGlobalUserName(String globalUserName) {
        this.globalUserName = globalUserName;
    }

    @Override
    public String toString() {
        return "ClassPojo [globalUserName = " + globalUserName + ", globalScUrl = " + globalScUrl + "]";
    }

}
