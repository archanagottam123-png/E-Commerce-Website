package com.example.ecommerce.config;

import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedData(CategoryRepository categoryRepository, ProductRepository productRepository) {
        return args -> {
            if (categoryRepository.count() == 0) {
                Category electronics = new Category();
                electronics.setName("Electronics");
                electronics.setDescription("Latest gadgets and digital products");
                categoryRepository.save(electronics);

                Category fashion = new Category();
                fashion.setName("Fashion");
                fashion.setDescription("Trendy outfits and accessories");
                categoryRepository.save(fashion);

                Category home = new Category();
                home.setName("Home");
                home.setDescription("Comfort and modern living items");
                categoryRepository.save(home);
            }

            if (productRepository.count() == 0) {
                Category electronics = categoryRepository.findAll().stream().filter(c -> c.getName().equals("Electronics")).findFirst().orElseThrow();
                Category fashion = categoryRepository.findAll().stream().filter(c -> c.getName().equals("Fashion")).findFirst().orElseThrow();
                Category home = categoryRepository.findAll().stream().filter(c -> c.getName().equals("Home")).findFirst().orElseThrow();

                Product p1 = new Product();
                p1.setName("Smartphone X");
                p1.setDescription("Flagship smartphone with AMOLED display");
                p1.setBrand("Nexa");
                p1.setPrice(799);
                p1.setDiscount(10);
                p1.setStockQuantity(25);
                p1.setImageUrl("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=800&q=80");
                p1.setRating(4.7);
                p1.setCategory(electronics);
                productRepository.save(p1);

                Product p2 = new Product();
                p2.setName("Wireless Headphones");
                p2.setDescription("Noise cancelling headphones");
                p2.setBrand("AudioMax");
                p2.setPrice(149);
                p2.setDiscount(5);
                p2.setStockQuantity(30);
                p2.setImageUrl("https://images.unsplash.com/photo-1505740420928-5e560c06d30e?auto=format&fit=crop&w=800&q=80");
                p2.setRating(4.5);
                p2.setCategory(electronics);
                productRepository.save(p2);

                Product p3 = new Product();
                p3.setName("Sneaker Boost");
                p3.setDescription("Premium comfort sneakers");
                p3.setBrand("RunFast");
                p3.setPrice(89);
                p3.setDiscount(8);
                p3.setStockQuantity(20);
                p3.setImageUrl("https://images.unsplash.com/photo-1542291026-7eec264c27ff?auto=format&fit=crop&w=800&q=80");
                p3.setRating(4.3);
                p3.setCategory(fashion);
                productRepository.save(p3);

                Product p4 = new Product();
                p4.setName("Ceramic Lamp");
                p4.setDescription("Minimal room decor lamp");
                p4.setBrand("HomeGlow");
                p4.setPrice(59);
                p4.setDiscount(7);
                p4.setStockQuantity(15);
                p4.setImageUrl("https://images.unsplash.com/photo-1513694203232-719a280e022f?auto=format&fit=crop&w=800&q=80");
                p4.setRating(4.6);
                p4.setCategory(home);
                productRepository.save(p4);
            }
        };
    }
}
