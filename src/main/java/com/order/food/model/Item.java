package com.order.food.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    private int id;
    private String name;
    private String currency;
    private int price;
    private String imagePath;
    private int quantity;
    private int total;
}
