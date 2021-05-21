package com.example.pizzariadommortandello.dataSQLite;

public class Pizza {

    private long id;
    private float price;
    private String name;
    private String timeStamp;
    private String description;

    public Pizza(long id, float price, String name, String timeStamp, String description) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.timeStamp = timeStamp;
        this.description = description;
    }

    public Pizza() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}