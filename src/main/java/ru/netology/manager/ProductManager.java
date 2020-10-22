package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepo;

public class ProductManager {
    private Product[] items = new Product[0];
    private ProductRepo repository;

    public ProductManager(ProductRepo repository) {
        this.repository = repository;
    }

    //public ProductManager() {}

    public void add(Product item) {
        repository.save(item);
        //int length = items.length + 1;
        //Product[] tmp = new Product[length];
        //for (int i = 0; i < items.length; i++) {
        //    tmp[i] = items[i];
        //}
        //int lastIndex = tmp.length - 1;
        //tmp[lastIndex] = item;
        //items = tmp;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                if (result.length + 1 >= 0) System.arraycopy(tmp, 0, result, 0, result.length + 1);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}
