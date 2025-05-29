package app;

public enum Poligono {
	QUADRADO(4) {
		@Override
		public double calcularArea(double aresta) {
			return aresta * aresta;
		}
	},
	TRIANGULO_EQUILATERO(3) {
		@Override
		public double calcularArea(double aresta) {
			return aresta * aresta * Math.sqrt(3) / 4;
		}
	},
	HEXAGONO_REGULAR(6) {
		@Override
		public double calcularArea(double aresta) {
			return 3 * aresta * aresta * Math.sqrt(3) / 2;
		}
	};

	private final int lados;

	Poligono(int lados) {
		this.lados = lados;
	}

	public int getLados() {
		return this.lados;
	}

	public double calcularPerimetro(double aresta) {
		return lados * aresta;
	}

	public abstract double calcularArea(double aresta);
}
