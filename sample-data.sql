USE ecommerce_db;

INSERT INTO roles (name) VALUES ('USER'), ('ADMIN');

INSERT INTO categories (name, description) VALUES
('Electronics', 'Latest gadgets and digital products'),
('Fashion', 'Trendy outfits and accessories'),
('Home', 'Comfort and modern living items');

INSERT INTO products (name, description, brand, price, discount, stock_quantity, image_url, rating, category_id) VALUES
('Smartphone X', 'Flagship smartphone with AMOLED display', 'Nexa', 799, 10, 25, 'https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=800&q=80', 4.7, 1),
('Wireless Headphones', 'Noise cancelling headphones', 'AudioMax', 149, 5, 30, 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?auto=format&fit=crop&w=800&q=80', 4.5, 1),
('Sneaker Boost', 'Premium comfort sneakers', 'RunFast', 89, 8, 20, 'https://images.unsplash.com/photo-1542291026-7eec264c27ff?auto=format&fit=crop&w=800&q=80', 4.3, 2),
('Ceramic Lamp', 'Minimal room decor lamp', 'HomeGlow', 59, 7, 15, 'https://images.unsplash.com/photo-1513694203232-719a280e022f?auto=format&fit=crop&w=800&q=80', 4.6, 3);
