package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepo;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {
    private ProductRepo repository;
    private ProductManager manager;
    ProductManagerTest(ProductRepo repository, ProductManager manager) {
        this.repository = repository;
        this.manager = manager; }
    Product first = new Book(1, "Цветы для Элджернона", 100, "Дэниел Киз");
    Product second = new Smartphone(2, "Samsung d100", 1000, "Samsung");
    Product third = new Book(3, "Дети Арбата", 100, "Анатолий Рыбаков");
    Product fourth = new Smartphone(3, "Xiaomi Redmi 5 Plus", 1000, "Xiaomi");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }
    @Test
    public void searchBy1() {
        manager.searchBy("Дети Арбата");
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{third};
        assertArrayEquals(actual, expected);
    }

    @Test
    public  void searchBy2() {
        manager.searchBy("Samsung");
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{second};
        assertArrayEquals(actual, expected);
    }
}