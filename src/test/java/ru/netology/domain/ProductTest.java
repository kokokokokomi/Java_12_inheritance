package ru.netology.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepo;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    ProductManager manager;
    ProductRepo repository = new ProductRepo();
    Book book1 = new Book(1, "Цветы для Элджернона", 100, "Дэниел Киз");
    Smartphone smartphone1 = new Smartphone(2, "Samsung d100", 1000, "Samsung");
    Book book2 = new Book(3, "Дети Арбата", 100,"Анатолий Рыбаков");
    Smartphone smartphone2 = new Smartphone(4, "Xiaomi Redmi 5 Plus", 1000, "Xiaomi");

    @Test
    void searchBy(String text) {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.searchBy("Дети");
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book2};
        assertArrayEquals(actual, expected);
    }
}