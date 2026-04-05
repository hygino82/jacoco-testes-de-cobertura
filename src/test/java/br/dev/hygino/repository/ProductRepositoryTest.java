package br.dev.hygino.repository;

import br.dev.hygino.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository;

    @BeforeEach
    public void setup() {
        repository = new ProductRepository();
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
}