package br.dev.hygino.util;

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
}