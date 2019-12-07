package com.saharsh.newsfeed.Models;

public class SourceModel {
    private String source_name, source_id;
    private int source_image;

    public SourceModel(String source_name, int source_image, String source_id) {
        this.source_name = source_name;
        this.source_image = source_image;
        this.source_id = source_id;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public int getSource_image() {
        return source_image;
    }

    public void setSource_image(int source_image) {
        this.source_image = source_image;
    }
}
