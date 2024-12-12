package com.order.food.controller;


import com.order.food.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log
public class HomeController {
    private ItemService itemService;

    @Value("${spring.profiles.active:UNKNOWN}")
    private String env;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = {"/", "/home"})
    public String index(Model model, HttpServletRequest request) {
        log.info("env = "+ env);
        loadHeaderAttributes(model,request);
        loadItems(model);
        return "home";
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
        /*model.addAttribute("cartCount", getCartCount(request));
        loadItems(model);
        model.addAttribute("cartTotal",itemService.getCartTotal());*/
        return "cart-content";
    }

    @GetMapping("/item/{itemId}")
    public String addItemToCart(Model model, @PathVariable int itemId, HttpServletRequest request) {
        int cartCount = getCartCount(request);
        if (cartCount >= 0) {
            request.getSession().setAttribute("cartCount", ++cartCount);
            itemService.addToCart(itemId, request);
        }
        model.addAttribute("cartCount", cartCount);
        return "cartCounter";
    }

    @DeleteMapping("/item/{itemId}")
    public String deleteItemFromCart(Model model, @PathVariable int itemId, HttpServletRequest request) {
        int cartCount = getCartCount(request);
        if (cartCount > 0) {
            cartCount -= 1;
            request.getSession().setAttribute("cartCount", cartCount);
            itemService.deleteFromCart(itemId, request);
        }
        model.addAttribute("cartCount", cartCount);
        loadItems(model);
        return "cartCounter";
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

    @GetMapping("/checkout")
    public String checkout(Model model, HttpServletRequest request) {
        loadHeaderAttributes(model,request);
        loadItems(model);
        model.addAttribute("cartTotal",itemService.getCartTotal());
        log.info("in checkout");
        return "checkout";
    }

    @GetMapping("/contact")
    public String contact(Model model, HttpServletRequest request) {
        log.info("in checkout");
        loadHeaderAttributes(model,request);
        return "contact";
    }

    @GetMapping("/testimonial")
    public String testimonial(Model model, HttpServletRequest request) {
        log.info("in testimonial");
        loadHeaderAttributes(model,request);
        return "testimonial";
    }

    private void loadItems(Model model) {
        model.addAttribute("items", itemService.getItems());
    }

    private int getCartCount(HttpServletRequest request) {
        if (request.getSession().getAttribute("cartCount") != null) {
            return (Integer) request.getSession().getAttribute("cartCount");
        } else {
            request.getSession().setAttribute("cartCount", 0);
            return 0;
        }
    }

    private void loadHeaderAttributes(Model model, HttpServletRequest request) {
        model.addAttribute("env", env);
        model.addAttribute("cartCount", getCartCount(request));
    }


}
