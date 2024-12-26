package com.order.food.controller;

import com.order.food.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class IdentityController extends BaseController{
    public IdentityController(ItemService itemService) {
        super(itemService);
    }

    @GetMapping("/register")
    public String register(Model model, HttpServletRequest request) {
        log.info("in register");
        loadHeaderAttributes(model,request);
        return "register";
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

}
