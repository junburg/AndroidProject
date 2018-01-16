package com.example.gyeongsuk.underthefield.main.History;

/**
 * Created by Gyeongsuk on 2016-11-30.
 */

public class CardDataHdomestic {

    private String hDomesticUserName;
    private String hDomesticArtistName;
    private String hDomesticTitleName;
    private String hDomesticScUrl;

    public String gethDomesticUserName() {
        return hDomesticUserName;
    }

    public void sethDomesticUserName(String hDomesticUserName) {
        this.hDomesticUserName = hDomesticUserName;
    }

    public String gethDomesticArtistName() {
        return hDomesticArtistName;
    }

    public void sethDomesticArtistName(String hDomesticArtistName) {
        this.hDomesticArtistName = hDomesticArtistName;
    }

    public String gethDomesticTitleName() {
        return hDomesticTitleName;
    }

    public void sethDomesticTitleName(String hDomesticTitleName) {
        this.hDomesticTitleName = hDomesticTitleName;
    }

    public String gethDomesticScUrl() {
        return hDomesticScUrl;
    }

    public void sethDomesticScUrl(String hDomesticScUrl) {
        this.hDomesticScUrl = hDomesticScUrl;
    }



    @Override
    public String toString() {
        return "ClassPojo [hDomesticUserName = " + hDomesticUserName + ", hDomesticTitleName = " + hDomesticTitleName + ", hDomesticArtistName = " + hDomesticArtistName + ", hDomesticScUrl = " + hDomesticScUrl + "]";
    }

}
