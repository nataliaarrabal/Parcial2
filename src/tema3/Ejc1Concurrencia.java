package tema3;

public class Ejc1Concurrencia {
	
	static class TareaA extends Thread{
		private String nombre;
		
		public TareaA(String nombre) {
			this.nombre=nombre;
		}
		
		public void run() {
			
			for (int i=0;i<5;i++) {
				try {
                    // Imprime la variable 'nombre' que almacena el nombre asignado
                    System.out.println("Hilo ejecutándose (" + nombre + "): " + i);
                    
                    // Pausa de 50 milisegundos (requisito del ejercicio)
                    Thread.sleep(50); 
                } catch (InterruptedException e) {
                    // Es buena práctica manejar la interrupción en sleep
                    Thread.currentThread().interrupt();
                }
            }
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Crea y arranca dos instancias de TareaA
        TareaA t1 = new TareaA("Hebra 1");
        TareaA t2 = new TareaA("Hebra 2");
        
        t1.start();
        t2.start();
        
        // El main() sigue ejecutándose concurrentemente
        System.out.println("Fin del programa principal.");

	}

}
