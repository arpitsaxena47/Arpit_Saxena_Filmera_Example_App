package com.arpit.exampleapp;

public class productAdapter {

    private String title;
    private int id;
    private String picture;


    public productAdapter() {
    }

    public productAdapter(String title, int id, String picture) {
        this.title = title;
        this.picture = picture;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public String getPicture() {
        return picture;
    }

    public int getId() {
        return id;
    }


}
