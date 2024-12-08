package com.order.food.controller;


import com.order.food.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@AllArgsConstructor
@Log
public class HomeController {
    private ItemService itemService;

    @Value("${spring.profiles.active:UNKNOWN}")
    private String env;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/header")
    public String header() {
        log.info("in header");
        return "header";
    }

    @GetMapping("/footer")
    public String footer() {
        log.info("in footer");
        return "footer";
    }

    @GetMapping(value = {"/", "/home"})
    public String index(Model model, HttpServletRequest request) {
        log.info("env = "+ env);
        model.addAttribute("env", env);
        model.addAttribute("cartCount", getCartCount(request));
        loadItems(model);
        return "home";
    }


    @GetMapping("/home-content")
    public String homeContent(Model model) {
        loadItems(model);
        return "home-content";
    }

    private void loadItems(Model model) {
        model.addAttribute("items", itemService.getItems());
    }

    @GetMapping("/cartCounter")
    public String cartCounter(Model model, HttpServletRequest request) {
        model.addAttribute("cartCount", getCartCount(request));
        log.info("in cartCounter");
        return "cartCounter";
    }

    private int getCartCount(HttpServletRequest request) {
        if (request.getSession().getAttribute("cartCount") != null) {
            return (Integer) request.getSession().getAttribute("cartCount");
        } else {
            request.getSession().setAttribute("cartCount", 0);
            return 0;
        }
    }

    @PostMapping("/cart/{itemId}")
    public String addToCart(Model model, @PathVariable int itemId, HttpServletRequest request) {
        int cartCount = getCartCount(request);
        if (cartCount >= 0) {
            request.getSession().setAttribute("cartCount", ++cartCount);
            itemService.addToCart(itemId, request);
        }
        model.addAttribute("cartCount", cartCount);
        return "cartCounter";
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
        return "cartCounter";
    }

    @GetMapping("/cart")
    public String cart(Model model, HttpServletRequest request) {
        log.info("in cart");
        model.addAttribute("cartCount", getCartCount(request));
        loadItems(model);
        return "cart";
    }

    @GetMapping("/cart-content")
    public String cartContent(Model model, HttpServletRequest request) {
        log.info("in cart-content");
        model.addAttribute("cartCount", getCartCount(request));
        loadItems(model);
        return "cart-content";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        log.info("in checkout");
        loadItems(model);
        return "checkout";
    }

    @GetMapping("/checkout-content")
    public String checkoutContent(Model model) {
        loadItems(model);
        log.info("in checkout-content");
        return "checkout-content";
    }

    @GetMapping("/contact")
    public String contact() {
        log.info("in checkout");
        return "contact";
    }

}
