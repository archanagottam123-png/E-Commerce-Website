package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.CatalogService;
import com.example.ecommerce.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.ecommerce.dto.UserRegistrationDto;

import java.util.List;

@Controller
public class HomeController {
    private final CatalogService catalogService;
    private final UserService userService;

    public HomeController(CatalogService catalogService, UserService userService) {
        this.catalogService = catalogService;
        this.userService = userService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        List<Product> products = catalogService.getAllProducts();
        List<Category> categories = catalogService.getAllCategories();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserRegistrationDto dto, Model model) {
        try {
            userService.registerUser(dto);
            model.addAttribute("successMessage", "Registration successful. Please log in.");
            return "login";
        } catch (IllegalArgumentException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            return "register";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/products")
    public String products(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Product> products;
        if (keyword != null && !keyword.isBlank()) {
            products = catalogService.searchProducts(keyword);
        } else {
            products = catalogService.getAllProducts();
        }
        model.addAttribute("products", products);
        return "products";
    }
}
