package tema2;

public class RecursividadPotencia {
	

	    /**
	     * Calcula base^exponente de forma recursiva (asumiendo exponente >= 0).
	     * @param base La base de la potencia.
	     * @param exponente El exponente (entero positivo o cero).
	     * @return El resultado de la potencia.
	     */
	    public static long calcularPotencia(int base, int exponente) {
	        // 1. Caso Base (Condición de Parada)
	        // Pista: Cualquier número elevado a 0 es 1.
	    	if(exponente==0) {
	    		return 1;
	    	}

	        return(long) base*calcularPotencia(base,exponente-1);
	        
	        
	        // 2. Paso Recursivo
	        // Pista: b^e = b * b^(e-1)

	        // [Tu código para el paso recursivo aquí]
	    	
	    	
	        
	    }

	    public static void main(String[] args) {
	        int base = 2;
	        int exponente = 5; 
	        long resultado = calcularPotencia(base, exponente);
	        System.out.println(base + " elevado a la " + exponente + " es: " + resultado); // Debería ser 32

	        base = 3;
	        exponente = 0;
	        resultado = calcularPotencia(base, exponente);
	        System.out.println(base + " elevado a la " + exponente + " es: " + resultado); // Debería ser 1
	    }
	}


