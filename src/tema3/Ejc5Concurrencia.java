package tema3;

public class Ejc5Concurrencia {
	

// Asume que esta es tu clase principal

	    // CLASE MONITOR
	    static class Buffer {
	        private int dato;
	        private boolean disponible = false; // Estado del buffer

	        public synchronized void poner(int valor) throws InterruptedException {
	            while (disponible) { // Espera si el buffer está lleno
	                wait(); 
	            }
	            this.dato = valor;
	            System.out.println("-> [PROD] Puso: " + dato);
	            disponible = true; 
	            notifyAll(); // Notifica al Consumidor (ahora puede sacar)
	        }

	        public synchronized int sacar() throws InterruptedException {
	            while (!disponible) { // Espera si el buffer está vacío
	                wait();
	            }
	            int resultado = dato;
	            System.out.println("<- [CONS] Sacó: " + resultado);
	            disponible = false; // El buffer está ahora vacío
	            notifyAll(); // Notifica al Productor (ahora puede poner)
	            return resultado;
	        }
	    } // FIN DE LA CLASE BUFFER
	    
	    // CLASE PRODUCTOR
	    static class Productor implements Runnable {
	    	private Buffer buffer;
	    	public Productor(Buffer buffer) {
	    		this.buffer = buffer;
	    	}
	    	
	    	@Override
	    	public void run() {
	    		for (int i = 0; i < 5; i++) {
	    			try {
	    				buffer.poner(i);
	    				Thread.sleep(100);
	    			} catch (InterruptedException e) {
	    				Thread.currentThread().interrupt();
	    			}
	    		}
	    	}
	    } // FIN DE LA CLASE PRODUCTOR
	    
	    // CLASE CONSUMIDOR
	    static class Consumidor implements Runnable {
	    	private Buffer buffer;
	    	public Consumidor(Buffer buffer) {
	    		this.buffer = buffer;
	    	}
	    	
	    	@Override
	    	public void run() {
	    		for (int i = 0; i < 5; i++) {
	    			try {
	    				buffer.sacar();
	    				Thread.sleep(150);
	    			} catch (InterruptedException e) {
	    				Thread.currentThread().interrupt();
	    			}
	    		}
	    	}
	    } // FIN DE LA CLASE CONSUMIDOR
	    

	    public static void main(String[] args) throws InterruptedException {
	    	
	    	Buffer buffer = new Buffer();
	        
	        Thread productorThread = new Thread(new Productor(buffer), "Productor");
	        Thread consumidorThread = new Thread(new Consumidor(buffer), "Consumidor");
	        
	        System.out.println("Arrancando Productor y Consumidor...");
	        
	        productorThread.start(); //arranca hilos
	        consumidorThread.start();
	        
	        // Esperar a que ambas hebras terminen
	        productorThread.join();
	        consumidorThread.join();
	        
	        System.out.println("El programa principal terminó la ejecución de todas las hebras.");
	    }
	}