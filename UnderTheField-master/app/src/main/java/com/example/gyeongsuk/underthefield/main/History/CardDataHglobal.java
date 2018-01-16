package com.example.gyeongsuk.underthefield.main.History;

/**
 * Created by Gyeongsuk on 2016-12-02.
 */

public class CardDataHglobal {

    private String hGlobalUserName;
    private String hGlobalArtistName;
    private String hGlobalTitleName;
    private String hGlobalScUrl;

    public String gethGlobalUserName() {
        return hGlobalUserName;
    }

    public void sethGlobalUserName(String hGlobalUserName) {
        this.hGlobalUserName = hGlobalUserName;
    }

    public String gethGlobalArtistName() {
        return hGlobalArtistName;
    }

    public void sethGlobalArtistName(String hGlobalArtistName) {
        this.hGlobalArtistName = hGlobalArtistName;
    }

    public String gethGlobalTitleName() {
        return hGlobalTitleName;
    }

    public void sethGlobalTitleName(String hGlobalTitleName) {
        this.hGlobalTitleName = hGlobalTitleName;
    }

    public String gethGlobalScUrl() {
        return hGlobalScUrl;
    }

    public void sethGlobalScUrl(String hGlobalScUrl) {
        this.hGlobalScUrl = hGlobalScUrl;
    }

    @Override
    public String toString() {
        return "ClassPojo [hGlobalUserName = " + hGlobalUserName + ", hGlobalTitleName = " + hGlobalTitleName + ", gArtistName = " + hGlobalArtistName + ", hGlobalScUrl = " + hGlobalScUrl + "]";
    }

}


