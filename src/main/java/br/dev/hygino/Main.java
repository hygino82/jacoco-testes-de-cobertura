package br.dev.hygino;

import br.dev.hygino.repository.ProductRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final ProductRepository repository = new ProductRepository();

        var products = repository.getAllProducts();
        products.forEach(System.out::println);
    }
}