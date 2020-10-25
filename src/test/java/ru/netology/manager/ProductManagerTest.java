package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
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
    public void searchBy1() {
        Product[] actual = new Product[]{book2};
        Product[] expected = manager.searchBy("Дети Арбата");
        assertArrayEquals(actual, expected);
    }

    @Test
    public  void searchBy2() {
        Product[] actual = new Product[]{smartphone1};
        Product[] expected = manager.searchBy("Samsung");
        assertArrayEquals(actual, expected);
    }
}