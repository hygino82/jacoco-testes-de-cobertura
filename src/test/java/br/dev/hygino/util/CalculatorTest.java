package br.dev.hygino.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	public void setUp() {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("Deve retornar a soma de dois números corretamente")
	public void testCorrectSum() {
		final double firstNumber = 2.5, secondNumber = 3.0, expected = 5.5;
		double result = calculator.sum(firstNumber, secondNumber);
		assertEquals(expected, result,
				() -> String.format("A soma de %f %f não ser igual a %f", firstNumber, secondNumber, expected));
	}

	@Test
	@DisplayName("Deve retornar a soma de dois números incorretamente")
	public void testWrongSum() {
		double result = calculator.sum(2.5, 3);
		assertNotEquals(7.5, result, () -> "A soma de 2 e 3 deveria ser 5");
	}

	@Test
	@DisplayName("Deve retornar a subtração de dois números corretamente")
	public void testCorrectSubtract() {
		double result = calculator.subtract(5.0, 2.0);
		assertEquals(3.0, result, () -> "A subtração de 5 e 2 deveria ser 3");
	}

	@Test
	@DisplayName("Deve retornar a subtração de dois números incorretamente")
	public void testWrongSubtract() {
		double result = calculator.subtract(5.0, 2.0);
		assertNotEquals(4, result, () -> "A subtração de 5 e 2 deveria ser 3");
	}

	@Test
	@DisplayName("Deve retornar a multiplicação de dois números corretamente")
	public void testCorrectMultiply() {
		double result = calculator.multiply(4.0, 2.5);
		assertEquals(10.0, result, () -> "A multiplicação de 4 e 2.5 deveria ser 10");
	}

	@Test
	@DisplayName("Deve retornar a multiplicação de dois números incorretamente")
	public void testWrongMultiply() {
		double result = calculator.multiply(4.0, 2.5);
		assertNotEquals(12.0, result, () -> "A multiplicação de 4 e 2.5 deveria ser 10");
	}

	@Test
	@DisplayName("Deve retornar a divisão de dois números corretamente")
	public void testCorrectDivide() {
		double result = calculator.divide(10.0, 2.0);
		assertEquals(5.0, result, "A divisão de 10 e 2 deveria ser 5");
	}

	@Test
	@DisplayName("Deve retornar a divisão de dois números incorretamente")
	public void testWrongDivide() {
		double result = calculator.divide(10.0, 2.0);
		assertNotEquals(4.0, result, () -> "A divisão de 10 e 2 deveria ser 5");
	}

	@Test
	@DisplayName("Deve lançar uma exceção ao tentar dividir por zero")
	public void testDivideByZero() {
		var res = assertThrows(IllegalArgumentException.class, () -> calculator.divide(10.0, 0.0));
		assertEquals("Divisão por zero não é permitida.", res.getMessage(),
				() -> "A mensagem da exceção deveria ser 'Divisão por zero não é permitida.'");
	}

	@Test
	@DisplayName("Deve retornar a potência de dois números corretamente")
	public void testCorrectPower() {
		double result = calculator.power(2.0, 3.0);
		assertEquals(8.0, result, () -> "A potência de 2 elevado a 3 deveria ser 8");
	}

	@Test
	@DisplayName("Deve lançar uma exceção ao tentar calcular 0 elevado a um número não positivo")
	public void testZeroPowerNonPositive() {
		var res = assertThrows(IllegalArgumentException.class, () -> calculator.power(0.0, -1.0));
		assertEquals("0 elevado a um número não positivo não é definido.", res.getMessage(),
				() -> "A mensagem da exceção deveria ser '0 elevado a um número não positivo não é definido.'");
	}

	@Test
	@DisplayName("Deve lançar uma exceção ao tentar calcular 0 elevado a 0")
	public void testZeroPowerZero() {
		var res = assertThrows(IllegalArgumentException.class, () -> calculator.power(0.0, 0.0));
		assertEquals("0 elevado a um número não positivo não é definido.", res.getMessage(),
				() -> "A mensagem da exceção deveria ser '0 elevado a um número não positivo não é definido.'");
	}

	@Test
	@DisplayName("Deve retornar 0 ao calcular 0 elevado a um número positivo")
	public void testZeroPowerPositiveExponent() {
		// Cenário: 0 elevado a 2 deve ser 0
		double result = calculator.power(0.0, 2.0);
		assertEquals(0.0, result, () -> "0 elevado a qualquer expoente positivo deveria ser 0.");

		// Outro caso de teste para ter certeza
		double result2 = calculator.power(0.0, 10.0);
		assertEquals(0.0, result2, () -> "0 elevado a qualquer expoente positivo deveria ser 0.");
	}

	@Test
	@DisplayName("Deve retornar a raiz quadrada de um número corretamente")
	public void squareRootShouldReturnCorrectValue() {
		final double value = 81.0, expected = 9.0;
		final double result = calculator.squareRoot(value);
		assertEquals(expected, result,
				() -> String.format("A raiz quadrada de %f deve ser igual a %f", value, expected));
	}

	@Test
	@DisplayName("Deve retornar a raiz quadrada de um número corretamente")
	public void squareRootShouldThowIllegalArgumentExceptionWhenNegativeValue() {
		final double value = -81.0;
		final var expected = "A raíz quadrada de um número negativo não existe!";
		final var result = assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(value));

		assertEquals(expected, result.getMessage());
	}

	@Test
	@DisplayName("Deve retornar a média dos valores")
	public void getMediaShouldReturnMedia() {
		final double values[] = { 3, 2, 3, 4, 6, 6 };
		final double expected = 4.0;
		final var result = calculator.getMedia(values);

		assertEquals(expected, result, () -> String.format("A média dos valores deve ser %f", expected));
	}

	@Test
	@DisplayName("Deve lançar uma exceção quando o valor for negativo")
	public void logarithmShouldThrowIllegalArgumentExceptionWhenNegativeValue() {
		final double value = -1.0, base = 5.0;
		final var expected = "O valor do logaritmo deve ser maior que 0!";
		final var result = assertThrows(IllegalArgumentException.class, () -> calculator.logarithm(base, value));

		assertEquals(expected, result.getMessage());
	}

	@Test
	@DisplayName("Deve lançar uma exceção quando a base for menor que zero")
	public void logarithmShouldThrowIllegalArgumentExceptionWhenBaseLessThanZero() {
		final double value = 10.0, base = -1.0;
		final var expected = "A base do logaritmo deve ser maior que 0 e diferente de 1.";
		final var result = assertThrows(IllegalArgumentException.class, () -> calculator.logarithm(base, value));

		assertEquals(expected, result.getMessage());
	}

	@Test
	@DisplayName("Deve retornar o logaritmo de um número corretamente")
	public void logarithmShouldReturnLogarithm() {
		final double value = 81.0, base = 3.0, expected = 4.0;
		final var result = calculator.logarithm(base, value);

		assertEquals(expected, result,
				() -> String.format("O logaritmo de %f na base %f deve ser %f", value, base, expected));
	}
}
