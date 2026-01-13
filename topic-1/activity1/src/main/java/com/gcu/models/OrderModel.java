package com.gcu.models;

public class OrderModel {
    private int id;
    private String order_number;
    private String product_name;
    private int price;
    private int quantity;

    // Default constructor
    public OrderModel() {
    }

    // Constructor with all fields
    public OrderModel(int id, String order_number, String product_name, int price, int quantity) {
        this.id = id;
        this.order_number = order_number;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
