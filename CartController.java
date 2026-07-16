package com.example.ecommerce.controller;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.service.CatalogService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {
    private final CartService cartService;
    private final CatalogService catalogService;
    private final UserRepository userRepository;

    public CartController(CartService cartService, CatalogService catalogService, UserRepository userRepository) {
        this.cartService = cartService;
        this.catalogService = catalogService;
        this.userRepository = userRepository;
    }

    @GetMapping("/cart")
    public String cartPage(Authentication authentication, Model model) {
        if (authentication == null) {
            return "redirect:/login";
        }
        User user = userRepository.findByEmail(authentication.getName()).orElseThrow();
        model.addAttribute("cart", cartService.getOrCreateCart(user));
        return "cart";
    }

    @PostMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable Long productId, @RequestParam(defaultValue = "1") int quantity, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        User user = userRepository.findByEmail(authentication.getName()).orElseThrow();
        cartService.addProduct(user, productId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove/{itemId}")
    public String removeFromCart(@PathVariable Long itemId) {
        cartService.removeItem(itemId);
        return "redirect:/cart";
    }
}
