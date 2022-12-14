package com.appsomniacs.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int userId;
    private Integer id;

    private String title;


    public Post(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @SerializedName("body")
    private String text;

}
