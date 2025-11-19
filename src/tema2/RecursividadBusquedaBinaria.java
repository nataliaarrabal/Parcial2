package tema2;

public class RecursividadBusquedaBinaria {

	    /**
	     * Realiza una búsqueda binaria recursiva en un arreglo ordenado.
	     * @param arr El arreglo de enteros ordenado.
	     * @param target El valor a buscar.
	     * @param low El índice de inicio de la búsqueda.
	     * @param high El índice final de la búsqueda.
	     * @return El índice del target si se encuentra, o -1 si no existe.
	     */
	    public static int busquedaBinaria(int[] arr, int target, int low, int high) {
	        
	        // 1. Caso Base de Fracaso:
	        // Pista: ¿Cuándo los límites de búsqueda se cruzan?

	        // [Tu código para el caso base de fracaso aquí]
	    	
	   if(low>high)
		   return -1;
	        

	        // 2. Determinar el Punto Medio:
	        int mid = low + (high - low) / 2; // Evita desbordamiento de enteros
	        
	        // 3. Caso Base de Éxito:
	        // Pista: ¿El elemento del medio es el target?

	        // [Tu código para el caso base de éxito aquí]
	        if (arr[mid]==target)
	        	return mid;
	        

	        // 4. Paso Recursivo:
	        // Pista: Si target es menor, busca en la mitad izquierda. Si es mayor, en la mitad derecha.
	        
	        // [Tu código para los pasos recursivos aquí]
	        if (arr[mid]>target)
	        	return busquedaBinaria(arr, target,low,mid-1);
	        else return busquedaBinaria(arr,target,mid+1,high);
	    }

	    public static void main(String[] args) {
	        int[] datos = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
	        int objetivo1 = 23;
	        int objetivo2 = 100;
	        
	        // La llamada inicial se hace con los límites completos del arreglo: 0 y longitud - 1
	        
	        int indice1 = busquedaBinaria(datos, objetivo1, 0, datos.length - 1);
	        System.out.println("El objetivo " + objetivo1 + " está en el índice: " + indice1); // Debería ser 5
	        
	        int indice2 = busquedaBinaria(datos, objetivo2, 0, datos.length - 1);
	        System.out.println("El objetivo " + objetivo2 + " está en el índice: " + indice2); // Debería ser -1
	    }
	}


