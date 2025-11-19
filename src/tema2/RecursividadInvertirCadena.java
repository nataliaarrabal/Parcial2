package tema2;

public class RecursividadInvertirCadena {


	    /**
	     * Revierte una cadena de texto de forma recursiva.
	     * @param str La cadena de texto a invertir.
	     * @return La cadena invertida.
	     */
	    public static String revertirCadena(String str) {
	        
	        // 1. Caso Base:
	        // Pista: ¿Cuándo la cadena es tan corta que ya no necesita ser revertida?

	        // [Tu código para el caso base aquí]
	    	if (str.length()<=1)
	    		return str;
	        
	        // 2. Paso Recursivo:
	        // Pista: Debes aislar el primer carácter de la cadena, y luego añadirlo al final 
	        // del resultado de la llamada recursiva al resto de la cadena.
	        // Usa los métodos: str.substring(índice) y str.charAt(índice).

	        // [Tu código para el paso recursivo aquí]
	    	
	    	return revertirCadena(str.substring(1))+str.charAt(0);
	        
	    }

	    public static void main(String[] args) {
	        String texto1 = "recursividad";
	        System.out.println("Original: " + texto1);
	        System.out.println("Invertida: " + revertirCadena(texto1)); 
	        // Debería ser dadivisrucer

	        String texto2 = "java";
	        System.out.println("\nOriginal: " + texto2);
	        System.out.println("Invertida: " + revertirCadena(texto2)); 
	        // Debería ser avaj
	    }
	}


