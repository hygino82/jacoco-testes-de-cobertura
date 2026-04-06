package br.dev.hygino.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.dev.hygino.model.Category;
import br.dev.hygino.model.Product;

class ProductRepositoryTest {

	private ProductRepository repository;
	private int validId, invalidid;

	@BeforeEach
	public void setup() {
		repository = new ProductRepository();
		validId = 1;
		invalidid = 1000;
	}

	@Test
	public void getAllProductsShouldReturnListWithThreeElements() throws Exception {
		final var res = repository.getAllProducts();
		assertEquals(3, res.size(), "Deve retornar o total de elementos da lista");
		assertEquals("O Alienista", res.getFirst().getName());
		assertEquals("Dom Casmurro", res.get(1).getName());
		assertEquals("Mouse", res.getLast().getName());
	}

	@Test
	public void getProductsByCategoryShouldReturnListWithSameCategory() {
		final var category = Category.BOOKS;
		final var res = repository.getProductsByCategory(category);
		assertEquals(2, res.size(), "Deve retornar o total de elementos da lista com a mesma categoria");
		assertEquals("O Alienista", res.getFirst().getName());
		assertEquals("Dom Casmurro", res.getLast().getName());
	}

	@Test
	public void getByIdShouldReturnProductWhenIdIsValid() {
		final var res = repository.getById(validId);
		assertTrue(res.isPresent());
		assertEquals("O Alienista", res.get().getName());
	}

	@Test
	public void getByIdShouldReturnOptionalEmptyWhenIdIsInvalid() {
		final var res = repository.getById(invalidid);
		assertTrue(res.isEmpty());
	}

	@Test
	public void insertShouldBeValid() {
		Product p = new Product(6, "Escrava Isaura", 12.95, Category.BOOKS);
		final var res = repository.insert(p);
		assertTrue(res);
	}

	@Test
	public void removeShouldBeValid() {
		Product p = new Product(3, "Mouse", 30.0, Category.ELECTRONICS);
		final var res = repository.remove(p);
		assertTrue(res);
		assertEquals(2, repository.getAllProducts().size());
	}

	@Test
	public void removeShouldBeInvalidWhenProductNotInTheList() {
		Product p = new Product(6, "Escrava Isaura", 12.95, Category.BOOKS);
		final var res = repository.remove(p);
		assertFalse(res);
		assertEquals(3, repository.getAllProducts().size());
	}
}