package com.order.food.service;

import com.order.food.model.CartTotal;
import com.order.food.model.Item;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class ItemServiceImpl implements ItemService {
    private static String CURRENCY = "Rs. ";
    public static List<Item> items = new ArrayList<>();
    public static CartTotal cartTotal=new CartTotal();

    @PostConstruct
    public void loadItems() {
        items.add(new Item(1, "Masala Macoroni", CURRENCY, 40, "img/masala-macaroni.webp", 0, 0));
        items.add(new Item(2, "Semiya", CURRENCY, 30, "img/semiya.webp", 0, 0));
        items.add(new Item(3, "Upma", CURRENCY, 40, "img/upma.webp", 0, 0));
        items.add(new Item(4, "Lemon Rice", CURRENCY, 35, "img/lemon-rice.webp", 0, 0));
        items.add(new Item(5, "Poori Chana", CURRENCY, 40, "img/poori-chana.webp", 0, 0));
        items.add(new Item(6, "Masala Oats", CURRENCY, 30, "img/masala-oats.webp", 0, 0));
        items.add(new Item(7, "Pongal", CURRENCY, 40, "img/pongal.webp", 0, 0));
        items.add(new Item(8, "Uggani", CURRENCY, 40, "img/uggani.webp", 0, 0));

    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void addToCart(int itemId, HttpServletRequest request) {
        Item item = findItem(getItems(), itemId);
        updateItem(item, true);
        //update cart total
        cartTotal.setSubTotal(item.getPrice() + cartTotal.getSubTotal());
        cartTotal.setTotal(cartTotal.getSubTotal() + cartTotal.getDeliveryFee());
        log.info("item id " + itemId + " added to cart ");
    }

    @Override
    public void deleteFromCart(int itemId, HttpServletRequest request) {
        Item item = findItem(getItems(), itemId);
        updateItem(item, false);
        cartTotal.setSubTotal(cartTotal.getSubTotal() - item.getPrice());
        cartTotal.setTotal(cartTotal.getSubTotal() + cartTotal.getDeliveryFee());
        log.info("item id " + itemId + " deleted from cart ");
    }

    private void updateItem(Item item, boolean increment) {
        if (increment) {
            item.setQuantity(item.getQuantity() + 1);
        } else {
            item.setQuantity(item.getQuantity() - 1);
        }
        item.setTotal(item.getQuantity() * item.getPrice());
    }

    private Item findItem(List<Item> items, int itemId) {
        for (Item item : items) {
            if (item.getId() == itemId) {
                return item;
            }
        }
        //control will never come here
        return new Item();
    }
    @Override
    public CartTotal getCartTotal(){
        return cartTotal;
    }
}
