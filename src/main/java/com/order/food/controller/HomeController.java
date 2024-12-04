package com.order.food.controller;


import com.order.food.model.Item;
import com.order.food.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {
    private ItemService itemService;
    //private static int CART_COUNT = 0;

    @GetMapping("/header")
    public String header() {
        System.out.println("in header");
        return "header";
    }

    @GetMapping("/footer")
    public String footer() {
        System.out.println("in footer");
        return "footer";
    }

    @GetMapping("/cartCounter")
    public String cartCounter(Model model, HttpServletRequest request) {
       int cartCount = (Integer) request.getSession().getAttribute("cartCount");
        model.addAttribute("cartCount", cartCount);
        System.out.println("in cartCounter");
        return "cartCounter";
    }

    @GetMapping(value = {"/", "/home"})
    public String index(Model model, HttpServletRequest request) {
        int cartCount = 0;
        if (request.getSession().getAttribute("cartCount") == null) {
            request.getSession().setAttribute("cartCount", cartCount);
        } else {
            cartCount = (Integer) request.getSession().getAttribute("cartCount");
        }
        List<Item> items = itemService.getItems();
        model.addAttribute("items", items);
        model.addAttribute("cartCount", cartCount);
        return "home";
    }

    @GetMapping("/home-content")
    public String homeContent(Model model) {
        List<Item> items = itemService.getItems();
        model.addAttribute("items", items);
        System.out.println("in home-content");
        return "home-content";
    }

    @PostMapping("/addToCart/{itemId}")
    public String addToCart(Model model, @PathVariable int itemId, HttpServletRequest request) {
        int cartCount = (Integer) request.getSession().getAttribute("cartCount");
        cartCount++;
        itemService.addToCart(itemId,request);
        model.addAttribute("cartCount", cartCount);
        request.getSession().setAttribute("cartCount", cartCount);

        return "cartCounter";
    }


    @GetMapping("/cart")
    public String cart(Model model, HttpServletRequest request) {
        System.out.println("in cart");
        request.getSession().getAttribute("cartCount");
        return "cart";
    }

    @GetMapping("/cart-content")
    public String cartContent(Model model, HttpServletRequest request) {

        System.out.println("in cart-content");
        return "cart-content";
    }

    @GetMapping("/checkout")
    public String checkout() {
        System.out.println("in checkout");
        return "checkout";
    }

    @GetMapping("/checkout-content")
    public String checkoutContent(Model model) {
        //model.addAttribute("mainContent", "checkout-content");
        System.out.println("in checkout-content");
        return "checkout-content";
    }

    @GetMapping("/contact")
    public String contact() {
        System.out.println("in checkout");
        return "contact";
    }

   /* @GetMapping("/detail")
    public String detail(Model model) {
        System.out.println("in shop");
        model.addAttribute("detail", "active");
        return "detail";
    }

    @GetMapping("/search")
    public String search(Model model) {
        System.out.println("in search");
        model.addAttribute("search", "active");
        return "search";
    }*/

   /* @GetMapping("/testimonial")
    public String testimonial() {
        System.out.println("in testimonial");
        return "testimonial";
    }

    @GetMapping("/testimonial-content")
    public String testimonialContent(Model model) {
       // model.addAttribute("mainContent", "testimonial-content");
        System.out.println("in testimonial-content");
        return "testimonial-content";
    }
*/


}
