package br.dev.hygino.util;

import java.util.Arrays;

public final class Calculator {

	public Calculator() {
	}

	public <T extends Number> double sum(T a, T b) {
		return a.doubleValue() + b.doubleValue();
	}

	public <T extends Number> double subtract(T a, T b) {
		return a.doubleValue() - b.doubleValue();
	}

	public <T extends Number> double multiply(T a, T b) {
		return a.doubleValue() * b.doubleValue();
	}

	public <T extends Number> double divide(T a, T b) {
		if (b.doubleValue() == 0) {
			throw new IllegalArgumentException("Divisão por zero não é permitida.");
		}
		return a.doubleValue() / b.doubleValue();
	}

	public <T extends Number> double power(T a, T b) {
		if (a.doubleValue() == 0 && b.doubleValue() <= 0) {
			throw new IllegalArgumentException("0 elevado a um número não positivo não é definido.");
		}
		return Math.pow(a.doubleValue(), b.doubleValue());
	}

	public <T extends Number> double squareRoot(T a) {
		if (a.doubleValue() < 0) {
			throw new IllegalArgumentException("A raíz quadrada de um número negativo não existe!");
		}
		return Math.sqrt(a.doubleValue());
	}

	public double getMedia(double[] values) {
		return Arrays.stream(values).average().orElse(0.0);
	}

	public double logarithm(double base, double value) {
		if (base <= 0 || base == 1) {
			throw new IllegalArgumentException("A base do logaritmo deve ser maior que 0 e diferente de 1.");
		}

		if (value <= 0) {
			throw new IllegalArgumentException("O valor do logaritmo deve ser maior que 0!");
		}

		return Math.log(value) / Math.log(base);
	}
}