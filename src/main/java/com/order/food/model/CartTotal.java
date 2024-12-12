package com.order.food.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartTotal implements Serializable {
    private int subTotal;
    private int deliveryFee=20;
    private int total;
}
