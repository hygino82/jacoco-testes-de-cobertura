package app;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PoligonoTests {

	@Test
	public void deveCalcularAreaQuadrado() {
		Poligono p = Poligono.QUADRADO;
		var area = p.calcularArea(16);
		assertEquals(256, area);
	}

	@Test
	public void deveCalcularPerimetroQuadrado() {
		Poligono p = Poligono.QUADRADO;
		var perimetro = p.calcularPerimetro(16);
		assertEquals(64, perimetro);
	}

	@Test
	public void deveRetornarNumeroLados() {
		Poligono quadrado = Poligono.QUADRADO;
		Poligono trianguloEquilatero = Poligono.TRIANGULO_EQUILATERO;
		Poligono hexagonoRegular = Poligono.HEXAGONO_REGULAR;

		assertAll(
				() -> assertEquals(3, trianguloEquilatero.getLados()), 
				() -> assertEquals(4, quadrado.getLados()),
				() -> assertEquals(6, hexagonoRegular.getLados()));
	}

	@Test
	public void deveCalcularAreaTrianguloEquilatero() {
		Poligono p = Poligono.TRIANGULO_EQUILATERO;
		var area = p.calcularArea(16);
		final var esperado = 256 * Math.sqrt(3) / 4;
		assertEquals(esperado, area);
	}
	
	@Test
	public void deveCalcularAreaHexagonoRegular() {
		Poligono p = Poligono.HEXAGONO_REGULAR;
		var area = p.calcularArea(16);
		final var esperado = 3*256 * Math.sqrt(3) / 2;
		assertEquals(esperado, area);
	}
}
