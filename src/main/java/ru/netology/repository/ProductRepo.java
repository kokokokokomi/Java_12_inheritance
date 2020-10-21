package ru.netology.repository;
import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;

public class ProductRepo {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() !=id ) {
                tmp[index] = item;
                index ++;
            }
        }
        items = tmp;
    }

    //public Product findById(int id) {
    //    for (Product item : items) {
    //        if (item.getId() == id) {
    //            return item;
    //        }
    //    }
    //    return null;
    //}
}

