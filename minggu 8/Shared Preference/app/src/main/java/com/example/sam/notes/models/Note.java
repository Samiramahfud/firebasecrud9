package com.example.sam.notes.models;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Note {
    String title;
    Date date;
    String content;

    public Note(String title, Date date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }


    public String getContent() {
        return content;
    }

    public String getFormattedDate() {
        // Tampilan tanggal yang dicetak menjadi: 01 Mar 2019
        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        return formatter.format(date);
    }
}
