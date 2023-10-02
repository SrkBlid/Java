package practicaParciales;

public class PolinomiosUso implements Polinomios{
	//VARIABLES
	private double[] coeficientes;
	
	//GENERADORES
	public PolinomiosUso(double[] coeficientes) {
		this.coeficientes = coeficientes;
	}
	
	public PolinomiosUso suma(PolinomiosUso otro) {
		int gradoMaximo = Math.max(this.coeficientes.length, otro.coeficientes.length);
        double[] sumaCoeficientes = new double[gradoMaximo];
        for (int i = 0; i < this.coeficientes.length; i++) {
            sumaCoeficientes[i] += this.coeficientes[i];
        }

        for (int i = 0; i < otro.coeficientes.length; i++) {
            sumaCoeficientes[i] += otro.coeficientes[i];
        }

        return new PolinomiosUso(sumaCoeficientes);
	}
	
	public PolinomiosUso resta(PolinomiosUso otro) {
		int gradoMaximo = Math.max(this.coeficientes.length, otro.coeficientes.length);
        double[] restaCoeficientes = new double[gradoMaximo];
        for (int i = 0; i < this.coeficientes.length; i++) {
            restaCoeficientes[i] += this.coeficientes[i];
        }

        for (int i = 0; i < otro.coeficientes.length; i++) {
            restaCoeficientes[i] -= otro.coeficientes[i];
        }

        return new PolinomiosUso(restaCoeficientes);
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coeficientes.length - 1; i >= 0; i--) {
            if (coeficientes[i] != 0) {
                if (i > 0) {
                    sb.append(coeficientes[i]).append("x^").append(i);
                    sb.append(" + ");
                } else {
                    sb.append(coeficientes[i]);
                }
            }
        }
        return sb.toString();
    }
	
	public double evaluar(double x) {
		double resultado = 0.0;
		for (int i = 0; i < coeficientes.length; i++) {
            resultado += coeficientes[i] * Math.pow(x, i);
        }
		return resultado;
	}
	
	public static void main(String[] args) {
		double[] coeficientes1 = { 1, 0, -2, 3 }; // Representa 3x^3 - 2x^2 + 1
        double[] coeficientes2 = { 0, 2, 1 };    // Representa x^2 + 2x
        PolinomiosUso polinomio1 = new PolinomiosUso(coeficientes1);
        PolinomiosUso polinomio2 = new PolinomiosUso(coeficientes2);

        System.out.println("Polinomio 1: " + polinomio1);
        System.out.println("Polinomio 2: " + polinomio2);

        PolinomiosUso suma = polinomio1.suma(polinomio2);
        System.out.println("Suma: " + suma);

        PolinomiosUso producto = polinomio1.resta(polinomio2);
        System.out.println("Producto: " + producto);

        double valorEvaluado = polinomio1.evaluar(2);
        System.out.println("Polinomio 1 evaluado en x = 2: " + valorEvaluado);
	}

	@Override
	public Object suma(Object otro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object resta(Object otro) {
		// TODO Auto-generated method stub
		return null;
	}

}
