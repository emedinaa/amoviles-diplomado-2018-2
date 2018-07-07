package com.emedinaa.myfirstapp.model;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 7/7/18
 */
public class Item {

    private int id;
    private String title;

    public Item(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
