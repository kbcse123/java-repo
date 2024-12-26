package com.order.food.controller;

import com.order.food.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log
@Controller
public class CheckoutController extends BaseController {

    public CheckoutController(ItemService itemService) {
        super(itemService);
    }

    @GetMapping("/checkout")
    public String checkout(Model model, HttpServletRequest request) {
        loadHeaderAttributes(model,request);
        loadItems(model);
        model.addAttribute("cartTotal",itemService.getCartTotal());
        log.info("in checkout");
        return "checkout";
    }

}
