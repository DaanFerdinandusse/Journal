package com.example.daan.journal;

import android.widget.ImageView;

import java.io.Serializable;
import java.sql.Time;

public class Entry implements Serializable {
    private int id;
    private String title;
    private String content;
    private int mood;
    private String timestamp;

    public Entry(String title, String content, int mood) {
        this.title = title;
        this.content = content;
        this.mood = mood;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
