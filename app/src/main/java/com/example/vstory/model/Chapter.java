package com.example.vstory.model;

public class Chapter {
    private int id;
    private int order;
    private String name;
    private String content;

    public Chapter() {
    }

    public Chapter(int id, int order, String name, String content) {
        this.id = id;
        this.order = order;
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
