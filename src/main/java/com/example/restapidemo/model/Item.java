package com.example.restapidemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;


public class Item {
    private int id;
    private String item_name;
    private int price;
    private String description;

    public Item(int id, String item_name, int price, String description) {
        this.id = id;
        this.item_name = item_name;
        this.price = price;
        this.description = description;
    }

    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
