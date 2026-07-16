# TrendCart E-Commerce Website

A full-stack e-commerce website built with Java, Spring Boot, MySQL, Thymeleaf, Bootstrap, HTML, CSS, and JavaScript.

## Features
- Responsive home page with hero banner, featured products, categories, search, and latest products
- User registration, login, logout, and simple profile flow
- Admin dashboard for products and categories
- Product and category management screens
- Cart experience with add/remove flows
- REST endpoints for products, categories, and users

## Tech Stack
- Java 17+
- Spring Boot 3.3
- Spring MVC
- Spring Data JPA / Hibernate
- MySQL
- Thymeleaf
- Bootstrap 5
- Maven

## Project Structure
- src/main/java/com/example/ecommerce/controller
- src/main/java/com/example/ecommerce/service
- src/main/java/com/example/ecommerce/repository
- src/main/java/com/example/ecommerce/entity
- src/main/java/com/example/ecommerce/dto
- src/main/java/com/example/ecommerce/config
- src/main/resources/templates
- src/main/resources/static
- sql/schema.sql
- sql/sample-data.sql

## Setup Instructions
1. Install Java 17+ and MySQL.
2. Create a database named `ecommerce_db`.
3. Update database credentials in `src/main/resources/application.properties`.
4. Run the SQL files in order:
   - `sql/schema.sql`
   - `sql/sample-data.sql`
5. Start the app with:
   - `mvn spring-boot:run`
6. Open: http://localhost:10002/

## Database Tables
- users
- roles
- categories
- products
- carts
- cart_items
- wishlist
- orders
- order_items

## API Documentation
- GET /api/products
- GET /api/products/{id}
- GET /api/categories
- GET /api/users

## Notes
This portfolio-friendly project is designed to be beginner-friendly, interview-ready, and easy to extend for payment integration, order management, and authentication refinements.
