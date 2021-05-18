package com.example.vstory.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Story implements Serializable {

    private int id;
    private String title;
    private String author;
    private List<String> category;
    private String imgUrl;
    private String status;
    private String description;
    private String date_update;
    private int total_chapters;

    public Story() {
    }

    public Story(int id, String title, String author, List<String> category, String imgUrl, String status, String description, String date_update, int total_chapters) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.imgUrl = imgUrl;
        this.status = status;
        this.description = description;
        this.date_update = date_update;
        this.total_chapters = total_chapters;
    }


    @Override
    public String toString() {
        return "Story{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", total_chapters=" + total_chapters +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_update() {
        return date_update;
    }

    public void setDate_update(String date_update) {
        this.date_update = date_update;
    }

    public int getTotal_chapters() {
        return total_chapters;
    }

    public void setTotal_chapters(int total_chapters) {
        this.total_chapters = total_chapters;
    }
}
