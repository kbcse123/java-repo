package com.order.food.controller;

import com.order.food.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Log
public class CartController  extends BaseController{

    public CartController(ItemService itemService) {
        super(itemService);
    }

    @GetMapping("/cart")
    public String cart(Model model, HttpServletRequest request) {
        log.info("in cart");
        loadHeaderAttributes(model,request);
        loadItems(model);
        model.addAttribute("cartTotal",itemService.getCartTotal());
        return "cart";
    }

    @GetMapping("/cart-content")
    public String cartContent(Model model, HttpServletRequest request) {
        log.info("in cart-content");
        cart(model, request);
        return "cart-content";
    }
    @GetMapping("/cart/{itemId}")
    public String addToCart(Model model, @PathVariable int itemId, HttpServletRequest request) {
        int cartCount = getCartCount(request);
        if (cartCount >= 0) {
            request.getSession().setAttribute("cartCount", ++cartCount);
            itemService.addToCart(itemId, request);
        }
        model.addAttribute("cartCount", cartCount);
        cart(model, request);
        return "cart-content";
    }

    @DeleteMapping("/cart/{itemId}")
    public String deleteFromCart(Model model, @PathVariable int itemId, HttpServletRequest request) {
        int cartCount = getCartCount(request);
        if (cartCount > 0) {
            cartCount -= 1;
            request.getSession().setAttribute("cartCount", cartCount);
            itemService.deleteFromCart(itemId, request);
        }
        model.addAttribute("cartCount", cartCount);
        loadItems(model);
        cart(model, request);
        return "cart-content";
    }

}
