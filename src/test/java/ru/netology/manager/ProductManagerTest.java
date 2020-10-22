package ru.netology.manager;

import org.junit.jupiter.api.Test;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductManagerTest {
    ProductManager manager; //= new ProductManager();
    ProductRepo repository = new ProductRepo();

    //Product first = new Book(1, "Цветы для Элджернона", 100, "Дэниел Киз");
    //Product second = new Smartphone(2, "Samsung d100", 1000, "Samsung");
    //Product third = new Book(3, "Дети Арбата", 100, "Анатолий Рыбаков");
    //Product fourth = new Smartphone(4, "Xiaomi Redmi 5 Plus", 1000, "Xiaomi");
    Book book1 = new Book(1, "Цветы для Элджернона", 100, "Дэниел Киз");
    Smartphone smartphone1 = new Smartphone(2, "Samsung d100", 1000, "Samsung");
    Book book2 = new Book(3, "Дети Арбата", 100,"Анатолий Рыбаков");
    Smartphone smartphone2 = new Smartphone(4, "Xiaomi Redmi 5 Plus", 1000, "Xiaomi");

    @Test
    public void searchBy1() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.searchBy("Дети");
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book2};
        assertArrayEquals(actual, expected);
    }

    @Test
    public  void searchBy2() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        manager.searchBy("Samsung");
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(actual, expected);
    }
}