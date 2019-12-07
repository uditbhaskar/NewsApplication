package com.saharsh.newsfeed.Models;

public class NewsModel {
    private String news_title, news_desc, news_content,
            news_author, news_time, news_source_name,
            news_url, news_urlToImage;

    public NewsModel()
    {

    }
    public NewsModel(String news_title, String news_desc, String news_content,
                     String news_author, String news_time, String news_source_name,
                     String news_url, String news_urlToImage) {
        this.news_title = news_title;
        this.news_desc = news_desc;
        this.news_content = news_content;
        this.news_author = news_author;
        this.news_time = news_time;
        this.news_source_name = news_source_name;
        this.news_url = news_url;
        this.news_urlToImage = news_urlToImage;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_desc() {
        return news_desc;
    }

    public void setNews_desc(String news_desc) {
        this.news_desc = news_desc;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_author() {
        return news_author;
    }

    public void setNews_author(String news_author) {
        this.news_author = news_author;
    }

    public String getNews_time() {
        return news_time;
    }

    public void setNews_time(String news_time) {
        this.news_time = news_time;
    }

    public String getNews_source_name() {
        return news_source_name;
    }

    public void setNews_source_name(String news_source_name) {
        this.news_source_name = news_source_name;
    }

    public String getNews_url() {
        return news_url;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }

    public String getNews_urlToImage() {
        return news_urlToImage;
    }

    public void setNews_urlToImage(String news_urlToImage) {
        this.news_urlToImage = news_urlToImage;
    }
}
