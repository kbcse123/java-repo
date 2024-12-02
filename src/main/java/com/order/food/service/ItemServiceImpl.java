package com.order.food.service;

import com.order.food.model.Item;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
private static final String CURRENCY="Rs. ";
    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1,"Masala Macoroni", CURRENCY,40, "img/masala-macaroni.webp", 0,0));
        items.add(new Item(2,"Semiya (Vermicelli)", CURRENCY,30, "img/semiya.webp", 0,0));
        items.add(new Item(3,"Upma", CURRENCY,40, "img/upma.webp", 0,0));
        items.add(new Item(4,"Lemon Rice", CURRENCY,35, "img/lemon-rice.webp", 0,0));
        items.add(new Item(5,"Poori Chana", CURRENCY,40, "img/poori-chana.webp", 0,0));
        items.add(new Item(6,"Masala Oats", CURRENCY,30, "img/masala-oats.webp", 0,0));
        items.add(new Item(7,"Pongal", CURRENCY,40, "img/pongal.webp", 0,0));
        items.add(new Item(8,"Uggani (Puffed Rice)", CURRENCY,40, "img/uggani.webp", 0,0));

        return items;
    }

    @Override
    public void addToCart(int itemId, HttpServletRequest request) {
        System.out.println("item id " + itemId + " added to cart ");
        List<Item> items ;
        Item item;
        if(request.getSession().getAttribute("selectedItems") == null){
            items = new ArrayList<>();
            item = findItem(getItems(),itemId);
            updateItem(item);
            items.add(item);
        }else{
            items = (List<Item>) request.getSession().getAttribute("selectedItems");
            item = findItem(items,itemId);
            if(item == null){
                item = findItem(getItems(),itemId);
                updateItem(item);
                items.add(item);
            }else{
                updateItem(item);
            }
        }
        request.getSession().setAttribute("selectedItems",items);
    }

    private void updateItem(Item item) {
        item.setQuantity(item.getQuantity()+1);
        item.setTotal(item.getQuantity() * item.getPrice());
    }

    private Item findItem(List<Item> items, int itemId) {
        for(Item item: items){
            if(item.getId() == itemId){
                return item;
            }
        }
        return null;
    }
}
