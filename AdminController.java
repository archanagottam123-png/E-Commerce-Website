package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final CatalogService catalogService;

    public AdminController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Product> products = catalogService.getAllProducts();
        List<Category> categories = catalogService.getAllCategories();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "admin/dashboard";
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", catalogService.getAllProducts());
        model.addAttribute("product", new ProductDto());
        return "admin/products";
    }

    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") ProductDto dto) {
        catalogService.saveProduct(dto);
        return "redirect:/admin/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        catalogService.deleteProduct(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/categories")
    public String categories(Model model) {
        model.addAttribute("categories", catalogService.getAllCategories());
        model.addAttribute("category", new CategoryDto());
        return "admin/categories";
    }

    @PostMapping("/categories")
    public String saveCategory(@ModelAttribute("category") CategoryDto dto) {
        catalogService.saveCategory(dto);
        return "redirect:/admin/categories";
    }
}
