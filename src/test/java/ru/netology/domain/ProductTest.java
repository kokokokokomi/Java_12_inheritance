package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepo;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    ProductRepo repository = new ProductRepo();
    ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(1, "Цветы для Элджернона", 100, "Дэниел Киз");
    Smartphone smartphone1 = new Smartphone(2, "Samsung d100", 1000, "Samsung");
    Book book2 = new Book(3, "Дети Арбата", 100,"Анатолий Рыбаков");
    Smartphone smartphone2 = new Smartphone(4, "Xiaomi Redmi 5 Plus", 1000, "Xiaomi");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
    }

    @Test
    void bookAuthorTest() {
        String text = "Дэниел Киз";
        assertTrue(book1.matches(text));
    }

    @Test
    void bookNameTest() {
        String text = "Дети Арбата";
        assertTrue(book2.matches(text));
    }

    @Test
    void smartphoneNameTest() {
        String text = "Samsung d100";
        assertTrue(smartphone1.matches(text));
    }

    @Test
    void smartphoneManufacturerTest() {
        String text = "Xiaomi";
        assertTrue(smartphone2.matches(text));
    }
}