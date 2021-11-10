package ru.netology.domain;

import ru.netology.repository.ProductRepository;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    ProductRepository repo = new ProductRepository();

    public boolean matches(String name){
        if (getName().contains(name)) {
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public void setPrice(int price) {
        this.price = price;
    }

}

