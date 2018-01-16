package com.example.gyeongsuk.underthefield.main.Recommendation;

/**
 * Created by Gyeongsuk on 2016-11-29.
 */
public class User {

    public String artist;
    public String title;
    public String url;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String artist, String title, String url) {
        this.artist = artist;
        this.title = title;
        this.url = url;
    }
}