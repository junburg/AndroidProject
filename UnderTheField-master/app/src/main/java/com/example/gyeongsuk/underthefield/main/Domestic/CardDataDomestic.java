package com.example.gyeongsuk.underthefield.main.Domestic;

/**
 * Created by Gyeongsuk on 2016-12-03.
 */

public class CardDataDomestic {

    private String domesticUserName;
    private String domesticScUrl;

    public String getDomesticUserName() {
        return domesticUserName;
    }

    public void setDomesticUserName(String domesticUserName) {
        this.domesticUserName = domesticUserName;
    }

    public String getDomesticScUrl() {
        return domesticScUrl;
    }

    public void setDomesticScUrl(String domesticScUrl) {
        this.domesticScUrl = domesticScUrl;
    }

    @Override
    public String toString() {
        return "ClassPojo [domesticUserName = " + domesticUserName + ", domesticScUrl = " + domesticScUrl + "]";
    }
}
