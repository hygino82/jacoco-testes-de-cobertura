package br.dev.hygino.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class Product {
    private int id;
    private String name;
    private double price;
    private Category category;
}
