package br.dev.hygino.repository;

import java.util.*;

import br.dev.hygino.model.Category;
import br.dev.hygino.model.Product;

public final class ProductRepository {

    private final List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1, "O Alienista", 10.0, Category.BOOKS),
                new Product(2, "Dom Casmurro", 20.0, Category.BOOKS),
                new Product(3, "Mouse", 30.0, Category.ELECTRONICS)));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> getProductsByCategory(Category category) {
        return products.stream()
                .filter(p -> p.getCategory().equals(category))
                .toList();
    }
}
