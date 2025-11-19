package tema2;

public class EjercicioBusqueda {
	    public static boolean contieneElemento(int[] arr, int target) {
	    	
	    	for( int i=0;i<arr.length;i++)
	    		if(arr[i]==target) 
	    			return true;
	    	
	    	return false;
	    		
	    }
	    
public static int encontrarIndiceBinario(int[] arr, int target) {
			int low=0;
			int high=arr.length-1;
			
	        
			do {
				int mid=low+(high-low)/2;
				if(arr[mid]==target) {
					return mid;}
				else { if(arr[mid]>target) {
					high=mid-1;
			} else {low=mid+1;}}
	    }while (low<=high);
			
			
			return -1;
}

public static int encontrarPrimeraVocal(String texto) {
    
	if (texto==null||texto.length()==0){
		return -1;}
		
	for (int i=0;i<texto.length();i++) {
		char carAct=texto.charAt(i);
		char min=Character.toLowerCase(carAct);
		
		if (min=='a'||min=='e'||min=='i'||min=='o'||min=='u') {
			return i;
		}
	}return -1;
	
}

	    public static void main(String[] args) {
	        int[] datos = {5, 1, 9, 3, 7, 2};
	        int buscar1 = 3;
	        int buscar2 = 10;
	        
	        System.out.println("¿Contiene " + buscar1 + "? " + contieneElemento(datos, buscar1)); // true
	        System.out.println("¿Contiene " + buscar2 + "? " + contieneElemento(datos, buscar2)); // false
	        
	        int[] datosOrdenados = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
	        int buscar3 = 12;
	        int buscar4 = 40;

	        System.out.println("Índice de " + buscar1 + ": " + encontrarIndiceBinario(datosOrdenados, buscar3)); // 3
	        System.out.println("Índice de " + buscar2 + ": " + encontrarIndiceBinario(datosOrdenados, buscar4)); // -1
	        
	        String texto1 = "rthmsql";
	        String texto2 = "Algoritmos";
	        String texto3 = "Snd";

	        System.out.println("Primera vocal en '" + texto1 + "' está en: " + encontrarPrimeraVocal(texto1)); // -1
	        System.out.println("Primera vocal en '" + texto2 + "' está en: " + encontrarPrimeraVocal(texto2)); // 0 ('A')
	        System.out.println("Primera vocal en '" + texto3 + "' está en: " + encontrarPrimeraVocal(texto3)); // -1
	    }
	    
	}


