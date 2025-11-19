package tema2;

public class RecursividadSumaDigitos {


	    /**
	     * Calcula la suma de los dígitos de un número entero positivo n de forma recursiva.
	     * * @param n El número entero positivo.
	     * @return La suma de sus dígitos.
	     */
	    public static int sumarDigitos(int n) {
	        
	        // 1. Caso Base:
	        // Pista: ¿Qué pasa cuando al número solo le queda un dígito o llega a 0?

	        // [Tu código para el caso base aquí]
	    	
	    	if (n<=9)
	    			return n;
	        
	        
	        // 2. Paso Recursivo:
	        // Pista: Necesitas dos operadores matemáticos clave para separar el último dígito 
	        // y el resto del número.
	        // - El operador MÓDULO (%) te da el último dígito.
	        // - El operador DIVISIÓN ENTERA (/) te da el resto del número.

	        // [Tu código para el paso recursivo aquí]
	    	return (n%10)+sumarDigitos(n/10);
	        
	    }

	    public static void main(String[] args) {
	        int numero1 = 1234;
	        System.out.println("La suma de los dígitos de " + numero1 + " es: " + sumarDigitos(numero1)); // Debería ser 10

	        int numero2 = 9;
	        System.out.println("La suma de los dígitos de " + numero2 + " es: " + sumarDigitos(numero2));   // Debería ser 9
	    }
	}
	


