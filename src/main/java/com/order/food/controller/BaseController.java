package com.order.food.controller;


import com.order.food.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Optional;

@Component
public class  BaseController {
    protected ItemService itemService;

    @Value("${spring.profiles.active:UNKNOWN}")
    protected String env;

    public BaseController(ItemService itemService) {
        this.itemService = itemService;
    }


    protected void loadItems(Model model) {
        model.addAttribute("items", itemService.getItems());
    }

    protected int getCartCount(HttpServletRequest request) {

    return Optional.ofNullable(request.getSession().getAttribute("cartCount"))
                .map(cartCount -> (Integer) cartCount)
                .orElseGet(()->{
                    request.getSession().setAttribute("cartCount", 0);
                    return 0;
                });
    }

    protected void loadHeaderAttributes(Model model, HttpServletRequest request) {
        model.addAttribute("env", env);
        model.addAttribute("cartCount", getCartCount(request));
    }



}
