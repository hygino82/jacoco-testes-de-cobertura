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
		return products.stream().filter(p -> p.getCategory().equals(category)).toList();
	}

	public boolean insert(Product product) {
		return products.add(product);
	}

	public boolean remove(Product product) {
		return products.remove(product);
	}

	public Optional<Product> getById(int id) {
		return products.stream().filter(p -> p.getId() == id).findFirst();
	}

  public List<Product> getProductWithMaxValue(double value){
    if(value <= 0.0){
      throw new IllegalArgumentException("O valor deve ser positivo");
    }

    return products.stream()
      .filter(p  -> p.getPrice() <= value)
      .toList();
  }
}
